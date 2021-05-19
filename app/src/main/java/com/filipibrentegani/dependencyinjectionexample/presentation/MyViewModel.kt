package com.filipibrentegani.dependencyinjectionexample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipibrentegani.dependencyinjectionexample.data.models.FindRepositoriesResponse
import com.filipibrentegani.dependencyinjectionexample.domain.FindRepositoriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    private val repositories = MutableLiveData<FindRepositoriesResponse?>()
    val repositoriesLiveData: LiveData<FindRepositoriesResponse?> = repositories

    fun searchRepositories() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = FindRepositoriesUseCase().getRepositories("teste")
            repositories.postValue(result)
        }
    }
}