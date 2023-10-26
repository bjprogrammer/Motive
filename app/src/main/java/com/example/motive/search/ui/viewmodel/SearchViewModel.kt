package com.example.motive.search.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.motive.search.model.Geonames
import com.example.motive.search.usecases.GetSearchResultUsecase
import com.example.motive.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
internal class SearchViewModel @Inject constructor(
    private val getSearchResultUsecase: GetSearchResultUsecase
) : ViewModel() {
    private val _searchLiveData = MutableLiveData<Response<List<Geonames>?>>()
    val searchLiveData: LiveData<Response<List<Geonames>?>> = _searchLiveData

    fun searchText(query: String?) {
        _searchLiveData.value = Response.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = getSearchResultUsecase.invoke(query?:"")
                if (response?.isSuccessful == true) {
                    _searchLiveData.postValue(Response.Success(response.body()?.geonames))
                } else {
                    _searchLiveData.postValue(Response.Error("Something went wrong"))
                }
            } catch (exc: Exception) {
                _searchLiveData.postValue(Response.Error(exc.message))
            }
        }
    }
}