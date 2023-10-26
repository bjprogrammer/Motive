package com.example.motive.network.service

import com.example.motive.search.model.SearchResult
import retrofit2.Response
import retrofit2.http.*

interface NetworkService {
    @GET(SEARCH_API)
    fun getSearchResult(
        @Query("size") pageSize:Int,
        @Query("username") username: String,
        @Query("query") searchText: String
    ): Response<SearchResult>

    companion object {
        const val SEARCH_API = "searchJSON?name_startsWith={query}&maxRows={size}&username={username}"
    }
}