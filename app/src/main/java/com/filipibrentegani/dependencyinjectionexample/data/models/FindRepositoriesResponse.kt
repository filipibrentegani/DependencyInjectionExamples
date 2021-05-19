package com.filipibrentegani.dependencyinjectionexample.data.models

import com.google.gson.annotations.SerializedName

data class FindRepositoriesResponse(
        val items: List<RepositoryResponse>,
        @SerializedName("total_count") val totalItems: Int
)