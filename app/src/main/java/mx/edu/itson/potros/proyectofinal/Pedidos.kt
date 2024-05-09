package mx.edu.itson.potros.proyectofinal

import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import mx.edu.itson.potros.proyectofinal.adapter.ProductoAdapter


class Pedidos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pedidos)
        recuperarPedidoUsuarioActual()
    }

    override fun onPause() {
        super.onPause()
        // Limpiar la lista de productos cuando se cambia de actividad
        ProductoProvider.productoList.clear()
    }

    fun recuperarPedidoUsuarioActual() {
        val usuarioActual = FirebaseAuth.getInstance().currentUser?.email

        val db = FirebaseDatabase.getInstance()
        val pedidosRef = db.getReference("Pedidos")

        val query = pedidosRef.orderByChild("Cliente").equalTo(usuarioActual)

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (pedidoSnapshot in dataSnapshot.children) {
                    val pedido = pedidoSnapshot.getValue(Pedido::class.java)

                    ProductoProvider.productoList.clear()
                    pedido?.Productos?.let { ProductoProvider.productoList.addAll(it) }

                    if (pedido?.TipoPedido == "Órden personal") {
                        val rbTipoOrden = findViewById<RadioButton>(R.id.rbPersonal)
                        rbTipoOrden.isChecked = true
                    } else {
                        val rbTipoOrden = findViewById<RadioButton>(R.id.rbMesa)
                        rbTipoOrden.isChecked = true
                    }

                    val tvTotal = findViewById<TextView>(R.id.tvTotal)
                    tvTotal.text = "Total: $${pedido?.Total}"
                    initiRecyclerView()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("Error al recuperar el pedido: ${databaseError.message}")
            }
        })
    }

    fun initiRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.rvOrden)
        recyclerView.adapter = ProductoAdapter(ProductoProvider.productoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    
}