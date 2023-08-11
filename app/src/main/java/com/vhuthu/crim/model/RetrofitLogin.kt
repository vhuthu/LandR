package com.vhuthu.crim.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitLogin {
    @POST("auth/farmer")
    fun  // on below line we are creating a method to post our data.
            postData(@Body loginModel: LoginModel?): Call<LoginModel?>?
}