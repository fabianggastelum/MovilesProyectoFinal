package mx.edu.itson.potros.proyectofinal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.edu.itson.potros.proyectofinal.adapter.ProductoAdapter

class DetalleOrden : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_orden)
        initiRecyclerView()
    }

    fun initiRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.rvOrden)
        recyclerView.adapter = ProductoAdapter(ProductoProvider.productoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}