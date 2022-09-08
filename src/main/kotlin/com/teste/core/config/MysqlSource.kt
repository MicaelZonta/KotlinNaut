package com.teste.core.config

import com.zaxxer.hikari.HikariConfig
import io.micronaut.configuration.jdbc.hikari.HikariUrlDataSource
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Primary
import jakarta.inject.Singleton
import javax.sql.DataSource

@Factory
class MysqlSourceUrl{

    @Singleton
    @Primary
    fun dataSource(): DataSource? {
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:mysql://localhost:3307/testando"
        config.username = "root"
        config.password = "root"
        config.driverClassName = "com.mysql.cj.jdbc.Driver"
        config.connectionTestQuery = "SELECT 1"
        return HikariUrlDataSource(config)

    }

}