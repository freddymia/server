package com.ecommerce.server.repository

import com.ecommerce.server.model.Carro
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface CarroRepository : CrudRepository<Carro, UUID> {
    @Modifying
    @Query("UPDATE carro c SET c.estado = 1 WHERE c.id = ?1")
    fun updateEstadoCarroCheckout(carroId: UUID)
}