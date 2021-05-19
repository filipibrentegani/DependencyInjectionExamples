package com.filipibrentegani.dependencyinjectionexample.data

import com.filipibrentegani.dependencyinjectionexample.data.models.FindRepositoriesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FindRepositoriesRepository() {
    suspend fun getRepositories(text: String): FindRepositoriesResponse? {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(logging).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        val service = retrofit.create(GitHubApi::class.java)
        return service.getRepositories(text)
    }
}