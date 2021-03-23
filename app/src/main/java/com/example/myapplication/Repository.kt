package com.example.myapplication

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Repository(context: Context) {
    private val reference: WebServise by lazy { Retrofit.retrofit.create(WebServise::class.java) }
    private var cache: Posts? = null

    suspend fun getPosts(): Posts? {
        if (cache == null) {
            cache = reference.getPosts()
        }
        return cache
    }
}