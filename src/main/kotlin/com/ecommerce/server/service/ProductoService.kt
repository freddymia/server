package com.ecommerce.server.service

import com.ecommerce.server.commons.GenericService
import com.ecommerce.server.model.Producto
import java.util.*

interface ProductoService : GenericService<Producto, UUID> {
    fun findByCarroId(carroId: UUID?): MutableList<Producto>?
}