package com.example.a07demo.retrofit

import com.example.a07demo.detail.UserDetails
import com.example.a07demo.model.Data
import com.example.a07demo.model.Signin
import com.example.a07demo.test.UserAdditionalFacility
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {
    @POST("user/signIn")
    fun userSignIn(
        @Body signin: Signin
    ): Call<Data>


    @GET("user/listOfAdditionalFacility")
    fun userData(

    ): Call<UserAdditionalFacility>

    @GET("user/getUserInfo")
    fun userNameData(
    ): Call<UserDetails>

}