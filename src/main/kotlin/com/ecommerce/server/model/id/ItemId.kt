package com.ecommerce.server.model.id

import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
class ItemId : Serializable {
    var carroId: UUID? = null
    var productoId: UUID? = null

    constructor() {}
    constructor(carroId: UUID?, productoId: UUID?) {
        this.carroId = carroId
        this.productoId = productoId
    }
}