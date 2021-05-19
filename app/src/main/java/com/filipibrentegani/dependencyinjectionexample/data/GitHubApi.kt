package com.filipibrentegani.dependencyinjectionexample.data

import com.filipibrentegani.dependencyinjectionexample.data.models.FindRepositoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("search/repositories")
    suspend fun getRepositories(
        @Query("q") text: String,
        @Query("per_page") itemsPerPage: Int = 100,
        @Query("page") page: Int = 0
    ): FindRepositoriesResponse?
}