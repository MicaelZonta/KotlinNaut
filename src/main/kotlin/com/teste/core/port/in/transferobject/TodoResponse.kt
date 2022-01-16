package com.teste.port.`in`.transferobject

import io.micronaut.core.annotation.Introspected

@Introspected
data class TodoResponse(
    var id: Long? = null,
    var des: String? = null,
    var done: Boolean? = null
)