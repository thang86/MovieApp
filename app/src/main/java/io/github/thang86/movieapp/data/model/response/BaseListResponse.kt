package io.github.thang86.movieapp.data.model.response

import com.google.gson.annotations.SerializedName


data class BaseListResponse<T>(
    @SerializedName("page") val page: Int?,
    @SerializedName("total_results") val totalResults: Int?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("results") val results: T
)