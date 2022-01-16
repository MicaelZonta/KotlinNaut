package com.teste.infra.persistence.mysql.repository

import com.teste.infra.persistence.mysql.entity.TodoEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface TodoRepository : JpaRepository<TodoEntity, Long> {
}