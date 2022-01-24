package com.ecommerce.server.service

import com.ecommerce.server.commons.GenericServiceImpl
import com.ecommerce.server.model.Item
import com.ecommerce.server.model.id.ItemId
import com.ecommerce.server.repository.CarroRepository
import com.ecommerce.server.repository.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl(override val dao: CrudRepository<Item, ItemId>) : GenericServiceImpl<Item, ItemId>(), ItemService {

    @Autowired
    lateinit var itemRepository: ItemRepository

    @Autowired
    lateinit var carroRepository: CarroRepository

}