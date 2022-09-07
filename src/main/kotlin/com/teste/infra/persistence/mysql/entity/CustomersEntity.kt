package com.teste.infra.persistence.mysql.entity


import io.micronaut.core.annotation.Introspected
import javax.persistence.*

@Entity(name="Customers")
@Introspected
data class CustomersEntity (

    //@Id
    //var order_id: Int,

    //@Column
    //var product_id: Int,

    @EmbeddedId
    var customersPrimaryEntity: CustomersPrimaryEntity,

    @Column
    val amount: Int

)


