package com.teste.core.port.`in`

import com.teste.core.port.`in`.transferobject.TodoRequest
import com.teste.infra.persistence.mysql.entity.CustomersEntity
import com.teste.infra.persistence.mysql.entity.CustomersPrimaryEntity
import com.teste.infra.persistence.mysql.repository.CustumerRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post


@Controller("/todos")
class TodoPort(
    private val custumerRepository: CustumerRepository
) {

    @Post
    fun addTodo(todo: TodoRequest): HttpResponse<CustomersEntity> {
        var customersEntity = CustomersEntity(CustomersPrimaryEntity(todo.order_id, todo.product_id), todo.amount)
        //var customersEntity = CustomersEntity(todo.order_id, todo.product_id, todo.amount)

        customersEntity = custumerRepository.save(customersEntity)

        return HttpResponse.created(customersEntity)
    }

}