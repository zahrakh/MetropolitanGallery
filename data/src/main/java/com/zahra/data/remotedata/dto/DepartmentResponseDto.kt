package com.zahra.data.remotedata.dto

import com.google.gson.annotations.SerializedName

data class DepartmentResponseDto(
    @SerializedName("departments") val departments: ArrayList<DepartmentDto>? = null
)


data class DepartmentDto(
    @SerializedName("departmentId") val departmentId: Int? = null,
    @SerializedName("displayName") val displayName: String? = null
)