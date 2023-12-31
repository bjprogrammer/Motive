package com.example.motive.utils

sealed class Response<out T> {
    class Success<T>(val data:T): Response<T>()
    class Error(val message:String?): Response<Nothing>()
    class Loading: Response<Nothing>()
}