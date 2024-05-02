package mx.edu.itson.potros.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Bebidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bebidas)

        val btnOrdenar = findViewById<Button>(R.id.btnAgregar)
        btnOrdenar.setOnClickListener {
            startActivity(Intent(this, DetalleOrden::class.java))
        }
    }
}