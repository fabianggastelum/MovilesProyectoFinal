package mx.edu.itson.potros.proyectofinal.adapter

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.edu.itson.potros.proyectofinal.Producto
import mx.edu.itson.potros.proyectofinal.R

class ProductoViewHolder(view: View): RecyclerView.ViewHolder(view){


    val nombreProducto = view.findViewById<TextView>(R.id.tvNombreProducto)
    val precioProducto = view.findViewById<TextView>(R.id.tvPrecioProducto)
    val cantidadProducto = view.findViewById<EditText>(R.id.eTCantidadProducto)

    fun render(productoModel: Producto){
        nombreProducto.text = productoModel.nombre
        precioProducto.text = productoModel.precio.toString()
        cantidadProducto.hint = productoModel.cantidad.toString()

    }
}