package com.paweloot.network

import com.paweloot.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/todos")
    fun getPosts(): Observable<List<Post>>
}