package com.example.todoapp.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.example.todoapp.Sealed.ApiResponse
import retrofit2.Response
import java.net.SocketTimeoutException

fun Context.isOnline(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}

fun Context.showToast(text : String){
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}
 suspend fun <T : Any> handleResponse(apiCall: suspend () -> Response<T>): ApiResponse<T> {
    return try {
        val response = apiCall.invoke()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                ApiResponse.Success(body)
            } else {
                ApiResponse.Failure("Response body is empty")
            }
        } else {
            when (response.code()) {
                404 -> {
                    ApiResponse.Failure("Resource not found")
                }
                500 -> {
                    ApiResponse.Failure("Internal server error")
                }
                else -> {
                    ApiResponse.Failure("Unhandled response code: ${response.code()}")
                }
            }
        }
    } catch (e: SocketTimeoutException) {
        ApiResponse.Failure("Timeout error: ${e.message ?: "Timeout"}}")
    } catch (e: Exception) {
        ApiResponse.Failure(e.message ?: "An error occurred")
    }
}