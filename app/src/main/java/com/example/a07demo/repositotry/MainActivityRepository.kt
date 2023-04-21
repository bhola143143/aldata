package com.example.a07demo.repositotry

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.a07demo.detail.UserDetails
import com.example.a07demo.model.Data
import com.example.a07demo.model.Signin
import com.example.a07demo.retrofit.RetrofitClient
import com.example.a07demo.test.UserAdditionalFacility
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<Data>()
    val serviceSetterGetter1 = MutableLiveData<UserAdditionalFacility>()
    val serviceSetterGetter2 = MutableLiveData<UserDetails>()


    fun userSignIn(data: Signin): MutableLiveData<Data> {


        val call = RetrofitClient.apiInterface.userSignIn(data)

        call.enqueue(object : Callback<Data> {
            override fun onFailure(call: Call<Data>, t: Throwable) {

                Log.v("DEBUG : ", t.toString())

            }

            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {

                println("@@@ DEBUG : " + response.body().toString())

                val data = response.body()
                val responseData = data?.data
                val message = data?.message
                val status = data?.status
                val statusCode = data?.status_code


                serviceSetterGetter.value = Data(responseData, message, status, statusCode)


            }
        })




        return serviceSetterGetter
    }

    fun userData(): MutableLiveData<UserAdditionalFacility> {
        val call2 = RetrofitClient.apiInterface.userData()
        call2.enqueue(object : Callback<UserAdditionalFacility> {
            override fun onFailure(call: Call<UserAdditionalFacility>, t: Throwable) {


            }

            override fun onResponse(
                call: Call<UserAdditionalFacility>,
                response: Response<UserAdditionalFacility>
            ) {


                val data = response.body()
                val responseData = data?.data
                val message = data.toString()
                val status = data.toString()
                val statusCode = data?.status_code

                serviceSetterGetter1.value =
                    UserAdditionalFacility(responseData!!, message, status, statusCode)


            }
        })
        return serviceSetterGetter1
    }


    fun userNameData(): MutableLiveData<UserDetails> {
        val call3 = RetrofitClient.apiInterface.userNameData()
        call3.enqueue(object : Callback<UserDetails> {
            override fun onFailure(call: Call<UserDetails>, t: Throwable) {


            }

            override fun onResponse(
                call: Call<UserDetails>,
                response: Response<UserDetails>
            ) {


                val data = response.body()
                val responseData = data?.data
                val message = data.toString()
                val status = data.toString()
                val statusCode = data?.status_code

                serviceSetterGetter2.value = UserDetails(responseData, message, status, statusCode)


            }
        })
        return serviceSetterGetter2
    }


}