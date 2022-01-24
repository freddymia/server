package com.ecommerce.server.model

import com.ecommerce.server.enums.TipoProducto
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "producto")
data class Producto(
        @Id
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
        val id: UUID,

        @Column
        val nombre: String,

        @Column
        val sku: String,

        @Column
        val descripcion: String,

        @Column
        val precio: BigDecimal,

        @Column
        val tipo: TipoProducto,

        @OneToMany(mappedBy = "producto")
        val items: MutableList<Item>
) {}