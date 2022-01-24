package com.ecommerce.server.model

import com.ecommerce.server.enums.EstadoCompra
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "carro")
data class Carro(
        @Id
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
        val id: UUID,

        @Column
        val estado: EstadoCompra,

        @OneToMany(mappedBy = "carro")
        val items: MutableList<Item>
) {}