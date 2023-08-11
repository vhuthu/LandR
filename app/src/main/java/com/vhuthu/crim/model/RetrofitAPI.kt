package com.vhuthu.crim.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitAPI {

    @POST("register/farmer")
    fun  // on below line we are creating a method to post our data.
            postData(@Body dataModel: DataModel?): Call<DataModel?>?
}