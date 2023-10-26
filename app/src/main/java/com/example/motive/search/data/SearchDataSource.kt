package com.example.motive.search.data

import com.example.motive.search.model.SearchResult
import retrofit2.Response

interface SearchDataSource {
    suspend fun search(
        pageSize:Int,
        searchText: String
    ): Response<SearchResult>?
}