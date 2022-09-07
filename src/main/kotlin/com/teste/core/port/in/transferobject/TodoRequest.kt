package com.teste.core.port.`in`.transferobject

import io.micronaut.core.annotation.Introspected

@Introspected
data class TodoRequest(
    val order_id: Int,
    val product_id: Int,
    val amount: Int
)
