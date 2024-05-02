package mx.edu.itson.potros.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnPlatillos = findViewById<Button>(R.id.btnPlatillos)
        val btnBebidas = findViewById<Button>(R.id.btnBebidas)
        val btnPostres = findViewById<Button>(R.id.btnPostres)

        btnPlatillos.setOnClickListener {
            startActivity(Intent(this, Platillos::class.java))
        }

        btnBebidas.setOnClickListener {
            startActivity(Intent(this, Bebidas::class.java))
        }

        btnPostres.setOnClickListener {
            startActivity(Intent(this, Postres::class.java))
        }

    }
}