package com.ecommerce.server.controller

import com.ecommerce.server.dto.ItemDTO
import com.ecommerce.server.enums.EstadoCompra
import com.ecommerce.server.model.Item
import com.ecommerce.server.model.Producto
import com.ecommerce.server.model.id.ItemId
import com.ecommerce.server.service.CarroService
import com.ecommerce.server.service.ItemService
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
@RequestMapping("/api/v1/carro")
@CrossOrigin("*")
class CarroController {

    @Autowired
    lateinit var itemService: ItemService

    @Autowired
    lateinit var productoService: ProductoService

    @Autowired
    lateinit var carroService: CarroService

    @GetMapping("/{id}/productos")
    fun getById(@PathVariable id: UUID): List<Producto>? {
        return productoService.findByCarroId(id)
    }

    @PostMapping("/add-producto")
    fun addProductoToCarro(@RequestBody itemDTO: ItemDTO): ResponseEntity<Item> {
        val itemId = ItemId(itemDTO.carroId, itemDTO.productoId);
        val item = Item(itemId, itemDTO.cantidad)
        val obj = itemService.save(item)
        return ResponseEntity<Item>(obj, HttpStatus.OK)
    }

    @DeleteMapping("/remove-producto")
    fun removeProductoFromCarro(@RequestBody itemDTO: ItemDTO): ResponseEntity<Item> {
        val itemId = ItemId(itemDTO.carroId, itemDTO.productoId);
        val obj = itemService.get(itemId)
        if (obj != null) {
            itemService.delete(itemId)
        } else {
            return ResponseEntity<Item>(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity<Item>(obj, HttpStatus.OK)
    }

    @PostMapping("/update-producto")
    fun updateProductoFromCarro(@RequestBody itemDTO: ItemDTO): ResponseEntity<Item> {
        val itemId = ItemId(itemDTO.carroId, itemDTO.productoId)
        val obj = itemService.get(itemId)
        if (obj != null) {
            val item = Item(itemId, itemDTO.cantidad)
            itemService.save(item)
        } else {
            return ResponseEntity<Item>(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity<Item>(obj, HttpStatus.OK)
    }

    @GetMapping("/{id}/checkout")
    fun checkout(@PathVariable id: UUID): ResponseEntity<Float> {
        val carro = carroService.get(id)
        if (carro != null && carro.estado == EstadoCompra.PENDIENTE) {
            val totalCheckout = carroService.requestCheckoutByCarroId(id)
            return ResponseEntity<Float>(totalCheckout, HttpStatus.OK)
        }
        return ResponseEntity<Float>(HttpStatus.NOT_FOUND)
    }

}