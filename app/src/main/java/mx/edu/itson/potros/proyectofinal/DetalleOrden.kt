package mx.edu.itson.potros.proyectofinal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleOrden : AppCompatActivity() {

    var myList = listOf(
        Producto("Coca Cola", 15.0, 2),
        Producto("Papas", 10.0, 1),
        Producto("Hamburguesa", 25.0, 1),
        Producto("Papas", 10.0, 1),
        Producto("Hamburguesa", 25.0, 1),
        Producto("Papas", 10.0, 1),
        Producto("Hamburguesa", 25.0, 1),
        Producto("Papas", 10.0, 1),
        Producto("Hamburguesa", 25.0, 1),
        Producto("Papas", 10.0, 1),
        Producto("Hamburguesa", 25.0, 1),
        Producto("Papas", 10.0, 1),
        Producto("Hamburguesa", 25.0, 1),
        Producto("Papas", 10.0, 1),
        Producto("Hamburguesa", 25.0, 1),
        Producto("Papas", 10.0, 1),
        Producto("Hamburguesa", 25.0, 1),
        Producto("Papas", 10.0, 1),
        Producto("Hamburguesa", 25.0, 1),
        Producto("Papas", 10.0, 1),
        Producto("Hamburguesa", 25.0, 1))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_orden)
    }
}