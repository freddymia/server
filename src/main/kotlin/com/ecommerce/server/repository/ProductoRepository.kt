package com.ecommerce.server.repository

import com.ecommerce.server.model.Producto
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductoRepository : CrudRepository<Producto, UUID> {
    @Query("SELECT p FROM Item i JOIN i.producto p WHERE i.itemId.carroId = ?1")
    fun findByCarroId(carroId: UUID?): MutableList<Producto>?
}