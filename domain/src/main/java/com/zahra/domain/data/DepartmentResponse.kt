package com.zahra.domain.data


data class DepartmentResponse(
    val departments: ArrayList<Department>? = null
)


data class Department(
    val departmentId: Int? = null,
    val displayName: String? = null
)