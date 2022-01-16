package com.teste.port.`in`

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class HelloPort {

    @Get
    fun Hello(): String {
        return "Hello World"
    }

}