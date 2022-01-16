package com.teste.core.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class TodoModel(
    val id: Long?,
    val des: String,
    val done: Boolean
)
