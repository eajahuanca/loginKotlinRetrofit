package com.miramicodigo.restful_2.service

import com.miramicodigo.restful_2.model.LoginBody
import com.miramicodigo.restful_2.model.Persona
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PersonaService{
    @POST("affiliates/login")
    fun login(@Body loginBody: LoginBody): Call<Persona>

    companion object {
        val BASE_URL = "http://mba.torcidak.com/v1/";
    }
}