package com.example.a07demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a07demo.detail.UserDetails
import com.example.a07demo.model.Data
import com.example.a07demo.model.Signin
import com.example.a07demo.repositotry.MainActivityRepository
import com.example.a07demo.test.UserAdditionalFacility


class MainActivityViewModel : ViewModel() {

    private var servicesLiveData: MutableLiveData<Data>? = null
    private var servicesLiveData1: MutableLiveData<UserAdditionalFacility>? = null
    private var servicesLiveData2: MutableLiveData<UserDetails>? = null


    fun userSignIn(data: Signin): LiveData<Data>? {

        servicesLiveData = MainActivityRepository.userSignIn(data)
        return servicesLiveData
    }

    fun userData(): LiveData<UserAdditionalFacility> {
        servicesLiveData1 = MainActivityRepository.userData()
        return servicesLiveData1 as MutableLiveData<UserAdditionalFacility>
    }

    fun userNameData(): LiveData<UserDetails> {
        servicesLiveData2 = MainActivityRepository.userNameData()
        return servicesLiveData2 as MutableLiveData<UserDetails>
    }


}