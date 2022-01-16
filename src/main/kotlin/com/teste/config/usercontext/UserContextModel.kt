package com.teste.config.usercontext

import io.micronaut.runtime.http.scope.RequestScope

@RequestScope
class UserContextModel(){

    private var correlationId: String? = null
    private var transactionId: String? = null


    fun getCorrelationId(): String? {
        return this.correlationId
    }

    fun setCorrelationId(correlationId: String) {
        this.correlationId = correlationId
    }

    fun getTransactionId(): String? {
        return this.transactionId
    }

    fun setTransactionId(transactionId: String) {
        this.transactionId = transactionId
    }
}