package com.example.a07demo

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a07demo.viewmodel.MainActivityViewModel

class DashboardActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val recyclerview = findViewById<RecyclerView>(R.id.rec)
        recyclerview.layoutManager = LinearLayoutManager(this)

        context = this@DashboardActivity

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]



        mainActivityViewModel.userData().observe(this) { userData ->

/*

            if (userData.status_code == 200) {
                println("@@@ Settings: " + "${userData?.data}")
            }
*/






            for (i in 0 until userData.data.size) {
                //  println( userData.data[i].title + ":" + userData.data[i].id)

                //     println(" ${userData.data[i].id}: ${userData.data[i].title} ")


            }

            val adapter = ListAdapter(userData.data)

            recyclerview.adapter = adapter


        }


    }
}