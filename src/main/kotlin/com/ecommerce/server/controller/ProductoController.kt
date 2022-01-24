package com.ecommerce.server.controller

import com.ecommerce.server.model.Producto
import com.ecommerce.server.service.ProductoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/producto/")
@CrossOrigin("*")
class ProductoController {

    @Autowired
    lateinit var productoService: ProductoService

    @GetMapping("/all")
    fun getAll(): List<Producto>? {
        return productoService.all
    }

    @PostMapping("/save")
    fun save(@RequestBody producto: Producto): ResponseEntity<Producto> {
        val obj = productoService.save(producto)
        return ResponseEntity<Producto>(obj, HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Producto> {
        val producto = productoService.get(id)
        if (producto != null) {
            productoService.delete(id)
        } else {
            return ResponseEntity<Producto>(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    fun update(@PathVariable id: UUID, @RequestBody producto: Producto): ResponseEntity<Producto> {
        val obj = productoService.get(id)
        if (obj != null) {
            val obj = productoService.saveProductoByTipoProducto(producto)
            return ResponseEntity<Producto>(obj, HttpStatus.OK)
        }
        return ResponseEntity<Producto>(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/carro/{id}")
    fun getAllByCarritoId(@PathVariable id: UUID): MutableList<Producto>? {
        return productoService?.findByCarroId(id)
    }

}