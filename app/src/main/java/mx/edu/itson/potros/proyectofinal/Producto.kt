package mx.edu.itson.potros.proyectofinal

 class Producto() {
     var Nombre: String = ""
     var Precio: Double = 0.0
     var Cantidad: Int = 0
     constructor(Nombre: String, Precio: Double, Cantidad: Int) : this() {
         this.Nombre = Nombre
         this.Precio = Precio
         this.Cantidad = Cantidad
     }

}
