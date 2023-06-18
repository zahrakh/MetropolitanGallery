package com.zahra.data.remotedata.dto

import com.google.gson.annotations.SerializedName

data class DepartmentsDto(
    @SerializedName("departments") val departments: List<DepartmentDto>? = null
)

data class DepartmentDto(
    @SerializedName("departmentId") val departmentId: Int? = null,
    @SerializedName("displayName") val displayName: String? = null
)