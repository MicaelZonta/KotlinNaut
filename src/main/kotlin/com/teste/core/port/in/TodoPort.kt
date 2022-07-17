package com.teste.core.port.`in`

import com.teste.config.usercontext.UserContextHolder
import com.teste.config.usercontext.UserContextModel
import com.teste.core.port.`in`.transferobject.TodoRequest
import com.teste.core.port.`in`.transferobject.TodoResponse
import com.teste.infra.persistence.mysql.entity.TodoEntity
import com.teste.infra.persistence.mysql.repository.TodoRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post


@Controller("/todos")
class TodoPort(
    private val todoRepository: TodoRepository,
    val userContextHandler: UserContextHolder,
) {

    var userContextModel = UserContextModel()

    @Get
    fun getTodos(): HttpResponse<List<TodoResponse>> {
        println("CorrelationId: ${userContextHandler.getCorrelationId()}")
        println("TransactionId: ${userContextHandler.getTransactionId()}")

        //Lista Persistence
        val todoEntityList = todoRepository.findAll()

        //Lista PortIn
        val todoResponseList = mutableListOf<TodoResponse>()

        //Loop'
        todoEntityList.forEach {
            val todoResponse = TodoResponse()
            todoResponse.des = it.des
            todoResponse.id = it.id
            todoResponse.done = it.done

            todoResponseList.add(todoResponse)
        }

        //Retorna
        return HttpResponse.ok(todoResponseList)
    }

    @Post
    fun addTodo(todo: TodoRequest): HttpResponse<TodoResponse> {
        var todoEntity = TodoEntity(null, todo.des, todo.done)

        todoEntity = todoRepository.save(todoEntity)

        return HttpResponse.created(TodoResponse(todoEntity.id, todoEntity.des, todoEntity.done))
    }


}