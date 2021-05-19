package com.filipibrentegani.dependencyinjectionexample.domain

import com.filipibrentegani.dependencyinjectionexample.data.FindRepositoriesRepository
import com.filipibrentegani.dependencyinjectionexample.data.models.FindRepositoriesResponse

class FindRepositoriesUseCase {
    suspend fun getRepositories(text: String): FindRepositoriesResponse? {
        val response = FindRepositoriesRepository().getRepositories(text)
        response?.items?.forEach {
            it.fullName = "UseCase - ${it.fullName}"
        }
        return response
    }
}