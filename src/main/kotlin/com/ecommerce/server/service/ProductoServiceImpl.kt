package com.ecommerce.server.service

import com.ecommerce.server.commons.GenericServiceImpl
import com.ecommerce.server.model.Producto
import com.ecommerce.server.repository.ProductoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductoServiceImpl(override val dao: CrudRepository<Producto, UUID>) : GenericServiceImpl<Producto, UUID>(), ProductoService {

    @Autowired
    lateinit var productoRepository: ProductoRepository

    override fun findByCarroId(carroId: UUID?): MutableList<Producto>? {
        return productoRepository.findByCarroId(carroId)
    }
}