package com.teste.config.usercontext

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.ClientFilterChain
import io.micronaut.http.filter.HttpClientFilter
import org.reactivestreams.Publisher

@Filter("/**")
class UserContextInterceptor(val userContextHandler: UserContextHolder) : HttpClientFilter {

    override fun doFilter(request: MutableHttpRequest<*>?, chain: ClientFilterChain?): Publisher<out HttpResponse<*>> {

        request?.headers?.add("correlation-id", userContextHandler.getCorrelationId())
        require(chain is ClientFilterChain) { "Passed FilterChain must be an instance of ServerFilterChain" }
        return chain.proceed(request)
    }


}