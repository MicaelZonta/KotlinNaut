package com.teste.config.usercontext

import io.micronaut.http.HttpRequest
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.HttpServerFilter
import io.micronaut.http.filter.ServerFilterChain
import org.reactivestreams.Publisher
import java.util.*

@Filter("/**")
class UserContextFilter(val userContextHandler: UserContextHolder) : HttpServerFilter {


    override fun doFilter(request: HttpRequest<*>?, chain: ServerFilterChain?): Publisher<MutableHttpResponse<*>> {
        require(chain is ServerFilterChain) { "Passed FilterChain must be an instance of ServerFilterChain" }

        var correlationID = UUID.randomUUID().toString()
        if (request?.headers?.contains("correlation-id") == true) {
            correlationID = request.headers.get("correlation-id").orEmpty()
        }

        userContextHandler.setCorrelationId(correlationID)
        userContextHandler.setTransactionId(UUID.randomUUID().toString())

        return chain.proceed(request)
    }

}