package com.zahra.data.remotedata.dto

import com.google.gson.annotations.SerializedName

data class ObjectsDto(
    @SerializedName("total") val total: Int? = null,
    @SerializedName("objectIDs") val objectIDs: List<Int>? = null
)