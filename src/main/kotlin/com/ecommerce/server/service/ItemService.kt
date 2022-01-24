package com.ecommerce.server.service

import com.ecommerce.server.commons.GenericService
import com.ecommerce.server.model.Item
import com.ecommerce.server.model.id.ItemId

interface ItemService : GenericService<Item, ItemId> {}