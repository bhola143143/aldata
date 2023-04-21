package com.example.a07demo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.a07demo.model.Signin
import com.example.a07demo.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.btnall)



        context = this@MainActivity


        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]



        button.setOnClickListener {
            val data = Signin("+19492883523", "Brain@2022")
            mainActivityViewModel.userSignIn(data)?.observe(this) { userData ->

                if (userData.status_code == 200) {
                    println("@@@ Settings: " + "${userData.data?.access_token}")
                    val token = "${userData.data?.access_token}"
                    val preferences: SharedPreferences =
                        this.getSharedPreferences("MY_APP", MODE_PRIVATE)
                    preferences.edit().putString("TOKEN", token).apply()

                    val intent = Intent(this@MainActivity, ContactInfo::class.java)
                    startActivity(intent)
                }
            }

        }

    }


}