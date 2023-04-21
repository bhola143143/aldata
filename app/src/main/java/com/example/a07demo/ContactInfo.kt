package com.example.a07demo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a07demo.viewmodel.MainActivityViewModel

class ContactInfo : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_info)
        val recyclerview = findViewById<RecyclerView>(R.id.rec)
        recyclerview.layoutManager = LinearLayoutManager(this)

        context = this@ContactInfo

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)



        mainActivityViewModel.userNameData().observe(this) { userData ->


            val adapter = ListNameAdapter(userData.data!!.relatives)
            recyclerview.adapter = adapter





        }


    }

}