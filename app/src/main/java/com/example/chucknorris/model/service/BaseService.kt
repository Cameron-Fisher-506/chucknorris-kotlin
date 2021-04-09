package com.example.chucknorris.model.service

import com.example.chucknorris.utils.Resource
import retrofit2.Response
import java.lang.Exception

abstract class BaseService {
    protected suspend fun <T> getResponse(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful && response.body() != null) {
                return Resource.success(response.body())
            }
            return Resource.error("Error Code: ${response.code()}\n\nError messsage: ${response.message()}")
        } catch (e: Exception) {
            return Resource.error(e.message ?: e.toString())
        }
    }
}