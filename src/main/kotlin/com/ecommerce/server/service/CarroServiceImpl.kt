package com.ecommerce.server.service

import com.ecommerce.server.commons.GenericServiceImpl
import com.ecommerce.server.model.Carro
import com.ecommerce.server.repository.CarroRepository
import com.ecommerce.server.repository.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class CarroServiceImpl(override val dao: CrudRepository<Carro, UUID>) : GenericServiceImpl<Carro, UUID>(), CarroService {

    @Autowired
    lateinit var carroRepository: CarroRepository

    @Autowired
    lateinit var itemRepository: ItemRepository

    @Transactional
    override fun requestCheckoutByCarroId(carroId: UUID): Float {
        carroRepository.updateEstadoCarroCheckout(carroId)
        return itemRepository.getTotalCheckoutByCarroId(carroId)
    }

}