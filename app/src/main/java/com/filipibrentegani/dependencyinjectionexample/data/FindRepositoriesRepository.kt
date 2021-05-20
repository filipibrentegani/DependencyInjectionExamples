package com.filipibrentegani.dependencyinjectionexample.data

import com.filipibrentegani.dependencyinjectionexample.data.models.FindRepositoriesResponse
import com.filipibrentegani.dependencyinjectionexample.domain.IFindRepositoriesRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FindRepositoriesRepository(private val service: GitHubApi) : IFindRepositoriesRepository {
    override suspend fun getRepositories(text: String): FindRepositoriesResponse? {
        return service.getRepositories(text)
    }
}