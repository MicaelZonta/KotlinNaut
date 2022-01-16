package com.teste.config.usercontext

import jakarta.inject.Provider
import jakarta.inject.Singleton

@Singleton
class UserContextHolder(private val requestScopeBean: Provider<UserContextModel>){

    fun getCorrelationId(): String {
        return requestScopeBean.get().getCorrelationId().orEmpty()
    }

    fun setCorrelationId(correlationId : String) {
        requestScopeBean.get().setCorrelationId(correlationId)
    }

    fun getTransactionId(): String {
        return requestScopeBean.get().getTransactionId().orEmpty()
    }

    fun setTransactionId(transactionId : String) {
        requestScopeBean.get().setTransactionId(transactionId)
    }

}