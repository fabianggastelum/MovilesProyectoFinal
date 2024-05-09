package mx.edu.itson.potros.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged

class Platillos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_platillos)

        val btnOrdenar = findViewById<Button>(R.id.btnAgregar)
        val cantidadPlatillo1 = findViewById<EditText>(R.id.platillo1)
        val cantidadPlatillo2 = findViewById<EditText>(R.id.platillo2)

        btnOrdenar.isEnabled = false

        cantidadPlatillo1.doOnTextChanged { text, _, _, _ ->
            btnOrdenar.isEnabled = text.toString().isNotEmpty()
        }

        cantidadPlatillo2.doOnTextChanged { text, _, _, _ ->
            btnOrdenar.isEnabled = text.toString().isNotEmpty()
        }


        btnOrdenar.setOnClickListener {
            if (cantidadPlatillo1.text.toString().isNotEmpty()
            ) {
                val cantidad = cantidadPlatillo1.text.toString().toInt()
                ProductoProvider.productoList.add(Producto("Camarones",
                    250.0 * cantidad, cantidad))

                startActivity(Intent(this, DetalleOrden::class.java))
            }

            if(cantidadPlatillo2.text.toString().isNotEmpty()
            ) {
                val cantidad = cantidadPlatillo2.text.toString().toInt()
                ProductoProvider.productoList.add(Producto("Tacos de pulpo",
                    150.0 * cantidad, cantidad))

                startActivity(Intent(this, DetalleOrden::class.java))
            }
        }
    }
}