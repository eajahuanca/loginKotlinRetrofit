package com.miramicodigo.restful_2.model

import com.google.gson.Gson
import okhttp3.ResponseBody
import java.io.IOException

class ApiError(var status: Int, var code: Int, var message: String?, var moreInfo: String?, var developerMessage: String?) {
    companion object {

        fun fromResponseBody(responseBody: ResponseBody): ApiError? {
            val gson = Gson()
            try {
                return gson.fromJson(responseBody.string(), ApiError::class.java)
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return null
        }
    }
}
