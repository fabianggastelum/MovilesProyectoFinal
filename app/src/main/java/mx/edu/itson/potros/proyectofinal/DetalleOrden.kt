package mx.edu.itson.potros.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import mx.edu.itson.potros.proyectofinal.adapter.ProductoAdapter

class DetalleOrden : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_orden)
        initiRecyclerView()

        val btnConfirmarOrden = findViewById<android.widget.Button>(R.id.confirmarOrden)
        val btnCancelarOrden = findViewById<android.widget.Button>(R.id.cancelarOrden)
        val btnAgregarProductos = findViewById<android.widget.Button>(R.id.agregarProductos)
        val tipoOrden = findViewById<RadioGroup>(R.id.rgTipoOrden)

        btnAgregarProductos.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

        btnCancelarOrden.setOnClickListener {
            ProductoProvider.productoList.clear()
            startActivity(Intent(this, Menu::class.java))
        }

        btnConfirmarOrden.setOnClickListener {
            // Initialize Firebase
            val database = FirebaseDatabase.getInstance()

            // Create a reference to the Firebase database
            val myRef = database.getReference("Pedidos")

            // Calculate the total amount of the order
            var total = 0.0
            for (product in ProductoProvider.productoList) {
                total += product.Precio
            }

            // Create a Map for each product in the productoList
            val productListMap = ProductoProvider.productoList.map{ product ->
                mapOf(
                    "Nombre" to product.Nombre,
                    "Precio" to product.Precio,
                    "Cantidad" to product.Cantidad
                )
            }

            // Get the selected radio button from the RadioGroup
            val selectedId = tipoOrden.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedId)

            val tipoPedido = selectedRadioButton.text.toString()

            val cliente = FirebaseAuth.getInstance().currentUser?.email

            // Create a Map for the order
            val orderMap = mapOf(
                "Total" to total,
                "Productos" to productListMap,
                "TipoPedido" to tipoPedido,
                "Cliente" to cliente
            )

            // Store the order in Firebase
            myRef.push().setValue(orderMap)

            ProductoProvider.productoList.clear()
            startActivity(Intent(this, Menu::class.java))
            Toast.makeText(this, "Orden confirmada", Toast.LENGTH_SHORT).show()
        }
    }

    fun initiRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.rvOrden)
        recyclerView.adapter = ProductoAdapter(ProductoProvider.productoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}