package com.paweloot.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paweloot.model.Post
import com.paweloot.model.PostDao

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val postDao: PostDao
}