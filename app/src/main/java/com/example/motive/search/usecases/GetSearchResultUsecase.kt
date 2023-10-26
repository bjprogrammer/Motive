package com.example.motive.search.usecases

import com.example.motive.search.data.SearchDataSource
import javax.inject.Inject

internal class GetSearchResultUsecase @Inject constructor(private val searchDataSource: SearchDataSource) {
    suspend fun invoke(searchText: String) = searchDataSource.search(PAGE_SIZE, searchText)

    companion object {
        private const val PAGE_SIZE = 10
    }
}