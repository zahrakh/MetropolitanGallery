package com.zahra.domain.data


data class Departments(
    val departments: List<Department>? = null
)

data class Department(
    val departmentId: Int? = null,
    val departmentName: String? = null
)