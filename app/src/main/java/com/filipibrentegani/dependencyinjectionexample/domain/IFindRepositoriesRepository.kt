package com.filipibrentegani.dependencyinjectionexample.domain

import com.filipibrentegani.dependencyinjectionexample.data.models.FindRepositoriesResponse

interface IFindRepositoriesRepository {
    suspend fun getRepositories(text: String): FindRepositoriesResponse?
}