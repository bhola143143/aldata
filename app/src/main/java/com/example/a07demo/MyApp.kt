package com.example.a07demo

import android.app.Application

class MyApp : Application() {

    companion object {
        private var instance: MyApp? = null

        fun getinstance(): MyApp? {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}