package com.filipibrentegani.dependencyinjectionexample.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.TestCase
import org.junit.Rule

class MyViewModelTest : TestCase() {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
}