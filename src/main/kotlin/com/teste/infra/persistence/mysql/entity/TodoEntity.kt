package com.teste.infra.persistence.mysql.entity

import io.micronaut.core.annotation.Introspected
import javax.persistence.*

@Entity
@Introspected
data class TodoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var des: String,

    @Column
    var done: Boolean

)


