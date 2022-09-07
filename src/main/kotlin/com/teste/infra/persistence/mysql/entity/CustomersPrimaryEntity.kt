package com.teste.infra.persistence.mysql.entity

import javax.persistence.Embeddable
import java.io.Serializable;


@Embeddable
data class  CustomersPrimaryEntity(

    var order_id: Int,
    var product_id: Int


): Serializable