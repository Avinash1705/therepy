package com.example.therapy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import com.example.therapy.data.ApiService
import com.example.therapy.models.Data
import com.example.therapy.models.therapyModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var gridview: GridView
    lateinit var dataApi: List<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()
        gridview = findViewById(R.id.gvMain)
        getApi()

    }


    private fun adapterSet(data: List<Data>) {
        Log.d("taken", "adapterSet: $data")
        val gridViewAdapter = gridViewAdapter(applicationContext, data)
        gridview.adapter = gridViewAdapter
    }

    private fun getApi() {
        var service = RetrofitHelper.getRetrofitHelper().create(ApiService::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val call = service.getTherapies()
            if (call.isSuccessful) {
                Log.d("rawat", "getApi: ${call.body()}")
                dataApi = call.body()!!.data
                Log.d("rawat", "dataApi: $dataApi")
                runOnUiThread(Runnable {
                    adapterSet(dataApi)
                })
            } else {
                Log.d("rawat", "getApi: ${call.errorBody()}")
            }
        }
    }
}