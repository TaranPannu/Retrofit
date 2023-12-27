package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getmyData()
    }

    private fun getmyData(){
        Toast.makeText(this,"Entered",Toast.LENGTH_SHORT).show()
        val retrofitBuilder= Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())//How to get json data and how to parse data
            .build()//to build api
            .create(TodoApi::class.java)
        Toast.makeText(this,"Entered "+retrofitBuilder,Toast.LENGTH_SHORT).show()

//ctrl+shoft +space
        val retrofitData=retrofitBuilder.getTodos()
        //press--->enqueue(ctrl+shoft +space//ctrl+shoft +space)
        Toast.makeText(this,retrofitData.toString(),Toast.LENGTH_SHORT).show()

        retrofitData.enqueue(object : Callback<Response<List<Todo>>?> {
            override fun onResponse(
                call: Call<Response<List<Todo>>?>,
                response: retrofit2.Response<Response<List<Todo>>?>
            ) {

val responseBody=response.body()!!// make it null safe
                val my=StringBuilder()
               /* for(myData in responseBody){
                    my.append(myData.id+" \n")

                }*/
Log.d("k21k",responseBody.toString())
                var txt=findViewById<TextView>(R.id.txt)
                txt.text=responseBody.toString()
                txt.text="text"
            }

            override fun onFailure(call: Call<Response<List<Todo>>?>, t: Throwable) {
                var txt=findViewById<TextView>(R.id.txt)
                txt.text="error"
                Log.d("k213k","responseBody.toString()")
            }

        })

    }
}