package com.teste.core.port.`in`.transferobject

import io.micronaut.core.annotation.Introspected

@Introspected
data class TodoRequest(
    val id: Long?,
    val des: String,
    val done: Boolean
)
