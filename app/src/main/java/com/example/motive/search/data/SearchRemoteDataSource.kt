package com.example.motive.search.data

import com.example.motive.network.service.NetworkService
import javax.inject.Inject

class SearchRemoteDataSource @Inject constructor(private val networkService: NetworkService) {
    suspend fun search(pageSize: Int, username: String, searchText: String) =
        networkService.getSearchResult(pageSize, username, searchText)
}
