package com.teste.infra.persistence.mysql.repository

import com.teste.infra.persistence.mysql.entity.CustomersEntity
import com.teste.infra.persistence.mysql.entity.CustomersPrimaryEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository


@Repository
interface CustumerRepository : CrudRepository<CustomersEntity, CustomersPrimaryEntity> {
}