package com.example.motive.search.model

import androidx.annotation.Keep

@Keep
data class SearchResult(
    val totalResultsCount : Int?,
    var geonames: List<Geonames>?
)