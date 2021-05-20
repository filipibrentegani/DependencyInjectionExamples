package com.filipibrentegani.dependencyinjectionexample.domain

import com.filipibrentegani.dependencyinjectionexample.data.FindRepositoriesRepository
import com.filipibrentegani.dependencyinjectionexample.data.models.FindRepositoriesResponse

class FindRepositoriesUseCase(private val repository: IFindRepositoriesRepository) {
    suspend fun getRepositories(text: String): FindRepositoriesResponse? {
        val response = repository.getRepositories(text)
        response?.items?.forEach {
            it.fullName = "UseCase - ${it.fullName}"
        }
        return response
    }
}