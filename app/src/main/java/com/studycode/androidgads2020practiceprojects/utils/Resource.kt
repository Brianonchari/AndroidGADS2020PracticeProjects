package com.studycode.androidgads2020practiceprojects.utils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

    }

}


sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
}

sealed class LoadingStatus() {
    class Loading(val message: String) : LoadingStatus()
    object Success : LoadingStatus()
    class Error(val message: String) : LoadingStatus()
}
//inline fun <reified T> Call<T>.enqueue(crossinline result: (Result<T>) -> Unit) {
//    enqueue(object: Callback<T> {
//        override fun onFailure(call: Call<T>, error: Throwable) {
//            result(Result.Failure(call, error))
//        }
//
//        override fun onResponse(call: Call<T>, response: Response<T>) {
//            result(Result.Success(call, response))
//        }
//    })
//}