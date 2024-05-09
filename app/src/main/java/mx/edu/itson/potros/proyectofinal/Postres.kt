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

class Postres : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_postres)

        val btnOrdenar = findViewById<Button>(R.id.btnAgregar)

        val cantidadPostre1 = findViewById<EditText>(R.id.postre1)
        val cantidadPostre2 = findViewById<EditText>(R.id.postre2)

        btnOrdenar.isEnabled = false

        cantidadPostre1.doOnTextChanged { text, _, _, _ ->
            btnOrdenar.isEnabled = text.toString().isNotEmpty()
        }

        cantidadPostre2.doOnTextChanged { text, _, _, _ ->
            btnOrdenar.isEnabled = text.toString().isNotEmpty()
        }


        btnOrdenar.setOnClickListener {
            if (cantidadPostre1?.text.toString().isNotEmpty()
            ) {
                val cantidad = cantidadPostre1.text.toString().toInt()
                ProductoProvider.productoList.add(Producto("Pastel de chocolate",
                    60.0 * cantidad, cantidad))

                startActivity(Intent(this, DetalleOrden::class.java))
            }

            if(cantidadPostre2?.text.toString().isNotEmpty()
            ) {
                val cantidad = cantidadPostre2.text.toString().toInt()
                ProductoProvider.productoList.add(Producto("Helado chalco",
                    80.0 * cantidad, cantidad))

                startActivity(Intent(this, DetalleOrden::class.java))
            }

        }
    }
}