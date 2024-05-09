package mx.edu.itson.potros.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged

class Bebidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bebidas)

        val btnOrdenar = findViewById<Button>(R.id.btnAgregar)
        val cantidadBebida1 = findViewById<EditText>(R.id.bebida1)
        val cantidadBebida2 = findViewById<EditText>(R.id.bebida2)

        btnOrdenar.isEnabled = false

        cantidadBebida1.doOnTextChanged { text, _, _, _ ->
            btnOrdenar.isEnabled = text.toString().isNotEmpty()
        }

        cantidadBebida2.doOnTextChanged { text, _, _, _ ->
            btnOrdenar.isEnabled = text.toString().isNotEmpty()
        }


        btnOrdenar.setOnClickListener {
            if (cantidadBebida1.text.toString().isNotEmpty()
            ) {
                val cantidad = cantidadBebida1.text.toString().toInt()
                ProductoProvider.productoList.add(Producto("Cerveza ultra",
                    45.0 * cantidad, cantidad))

                startActivity(Intent(this, DetalleOrden::class.java))
            }

            if(cantidadBebida2.text.toString().isNotEmpty()
            ) {
                val cantidad = cantidadBebida2.text.toString().toInt()
                ProductoProvider.productoList.add(Producto("Cerveza pacífico suave",
                    40.0 * cantidad, cantidad))

                startActivity(Intent(this, DetalleOrden::class.java))
            }
        }
    }
}