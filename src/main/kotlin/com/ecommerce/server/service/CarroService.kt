package com.ecommerce.server.service

import com.ecommerce.server.commons.GenericService
import com.ecommerce.server.model.Carro
import java.util.*
import javax.transaction.Transactional

interface CarroService : GenericService<Carro, UUID> {
    @Transactional
    fun requestCheckoutByCarroId(carroId: UUID): Float
}