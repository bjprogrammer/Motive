package com.example.motive.search.data

import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val remoteDataSource: SearchRemoteDataSource
) : SearchDataSource {
    override suspend fun search(pageSize: Int, searchText: String) =
        remoteDataSource.search(pageSize, USERNAME, searchText)

    companion object {
        private const val USERNAME = "keep_truckin"
    }
}