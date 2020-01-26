package com.paweloot.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.paweloot.model.database.AppDatabase
import com.paweloot.ui.PostListViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            val database = Room.databaseBuilder(
                activity.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()

            @Suppress("UNCHECKED_CAST")
            return PostListViewModel(database.postDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class!")
    }
}