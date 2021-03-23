package com.example.myapplication.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = (application as ArchApplication).repository

    init {
        loadPosts()
    }

    private val _posts: MutableLiveData<Resource<Posts>> = MutableLiveData()
    val posts: LiveData<Resource<Posts>> = _posts


    private fun loadPosts(){
        viewModelScope.launch(Dispatchers.IO) {
            _posts.postValue(Resource.Loading<Posts>())
            _posts.postValue(Resource.Success(repository.getPosts() ?: Posts()))
        }
    }
}