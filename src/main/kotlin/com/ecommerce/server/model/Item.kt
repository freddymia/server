package com.ecommerce.server.model

import com.ecommerce.server.model.id.ItemId
import com.fasterxml.jackson.annotation.JsonBackReference
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "item")
class Item : Serializable {
    @EmbeddedId
    var itemId: ItemId? = null

    @Column
    var cantidad: Float? = null

    constructor() {}
    constructor(itemId: ItemId?, cantidad: Float?) {
        this.itemId = itemId
        this.cantidad = cantidad
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "productoId", updatable = false, insertable = false)
    var producto: Producto? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "carroId", updatable = false, insertable = false)
    var carro: Carro? = null
}