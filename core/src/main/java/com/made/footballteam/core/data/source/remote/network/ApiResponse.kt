@file:Suppress("unused")

package com.made.footballteam.core.data.source.remote.network

@Suppress("unused")
sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: String) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}