package com.filipibrentegani.dependencyinjectionexample.data.models

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
        val id: Int,
        val name: String,
        @SerializedName("full_name") var fullName: String,
        val description: String = "",
        @SerializedName("svn_url") val repoUrl: String,
        val homepage: String = "",
        val language: String = "",
        @SerializedName("has_wiki") val hasWiki: Boolean
)