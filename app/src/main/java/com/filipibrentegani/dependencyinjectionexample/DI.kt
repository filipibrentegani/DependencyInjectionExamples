package com.filipibrentegani.dependencyinjectionexample

import com.filipibrentegani.dependencyinjectionexample.data.FindRepositoriesRepository
import com.filipibrentegani.dependencyinjectionexample.data.GitHubApi
import com.filipibrentegani.dependencyinjectionexample.domain.FindRepositoriesUseCase
import com.filipibrentegani.dependencyinjectionexample.domain.IFindRepositoriesRepository
import com.filipibrentegani.dependencyinjectionexample.presentation.MyAdapter
import com.filipibrentegani.dependencyinjectionexample.presentation.MyViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val moduleDI = module {

    factory {
        FindRepositoriesUseCase(get())
    }

    factory<IFindRepositoriesRepository> {
        FindRepositoriesRepository(get())
    }

    factory {
        get<Retrofit>().create(GitHubApi::class.java)
    }

    single {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(logging).build()

        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}

val moduleDI2 = module {

    viewModel {
        MyViewModel(get())
    }

    factory {
        MyAdapter()
    }
}