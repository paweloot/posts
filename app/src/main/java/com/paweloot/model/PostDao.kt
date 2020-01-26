package com.paweloot.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostDao {

    @Query("SELECT * from post_table")
    fun findAll(): List<Post>

    @Insert
    fun insertAll(vararg posts: Post)
}