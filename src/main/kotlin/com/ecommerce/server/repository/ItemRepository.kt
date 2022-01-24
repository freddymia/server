package com.ecommerce.server.repository

import com.ecommerce.server.model.Item
import com.ecommerce.server.model.id.ItemId
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ItemRepository : CrudRepository<Item, ItemId> {
    @Query("SELECT SUM(i.cantidad) FROM Item i WHERE i.itemId.carroId = ?1")
    fun getTotalCheckoutByCarroId(carroId: UUID): Float
}