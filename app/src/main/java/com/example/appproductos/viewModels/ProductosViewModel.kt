package com.example.appproductos.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appproductos.model.Producto
import com.example.appproductos.state.ProductoState

class ProductosViewModel : ViewModel() {

    // Estado inicial con algunos productos predefinidos
    var productoState by mutableStateOf(
        ProductoState(
            productos = listOf(
                Producto(
                    id = "1",
                    nombre = "Producto 1",
                    descripcion = "Descripción del producto 1",
                    fechaRegistro = "2024-01-01"
                ),
                Producto(
                    id = "2",
                    nombre = "Producto 2",
                    descripcion = "Descripción del producto 2",
                    fechaRegistro = "2024-02-01"
                )
            )
        )
    )
        private set

    // Función para agregar un nuevo producto
    fun agregarProducto(producto: Producto) {
        val nuevosProductos = productoState.productos.toMutableList()
        nuevosProductos.add(producto)
        productoState = productoState.copy(productos = nuevosProductos)
    }

    // Función para eliminar un producto por su id
    fun eliminarProducto(id: String) {
        val nuevosProductos = productoState.productos.filter { it.id != id }
        productoState = productoState.copy(productos = nuevosProductos)
    }

    // Función para obtener la lista actual de productos
    fun obtenerProductos(): List<Producto> {
        return productoState.productos
    }
}
