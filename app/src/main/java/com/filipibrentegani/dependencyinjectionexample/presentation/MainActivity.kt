package com.filipibrentegani.dependencyinjectionexample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.filipibrentegani.dependencyinjectionexample.R

class MainActivity : AppCompatActivity() {
    val viewModel = MyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MyAdapter()
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        viewModel.repositoriesLiveData.observe(this, Observer {
            it?.let {
                adapter.setItems(it.items)
            }
        })

        viewModel.searchRepositories()
    }


}