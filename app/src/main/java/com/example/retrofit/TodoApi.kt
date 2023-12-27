package com.example.retrofit

import com.android.volley.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TodoApi {//To define al function needed to call API
     // 4 types of Data requests
    // get -retrieve dta
   //post -post data on API
  //put- update data on server
 //delete- delete data on server

    //fun getTodos(@Query("key")kye:String): Response<List<Todo>>  //in case we have key to pass
    @GET("/todos")// endpoints-->write whatever come after base url ..after .com
    fun getTodos(): Call<Response<List<Todo>>>
// bcoz of suspend network request will not happen on main thread --> will happen async
}

/*[
  {
    "userId": 1,
    "id": 1,
    "title": "delectus aut autem",
    "completed": false
  },
  {
    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false
  }
  ]*/