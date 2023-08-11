package com.vhuthu.crim

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vhuthu.crim.model.DataModel
import com.vhuthu.crim.model.LoginModel
import com.vhuthu.crim.model.RetrofitAPI
import com.vhuthu.crim.model.RetrofitLogin
import com.vhuthu.crim.ui.theme.CrimTheme
import com.vhuthu.crim.ui.theme.greenColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrimTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // on the below line we are specifying the theme as the scaffold.
                    Scaffold(
                        // in scaffold we are specifying top bar.
                        topBar = {

                            // inside top bar we are specifying background color.
                            TopAppBar(

                                // along with that we are specifying title for our top bar.
                                title = {

                                    // in the top bar we are specifying tile as a text
                                    Text(
                                        // on below line we are specifying text to display in top app bar.
                                        text = "Retrofit POST Request in Android",

                                        // on below line we are specifying modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying text alignment.
                                        textAlign = TextAlign.Center,

                                        // on below line we are specifying color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {
                        // on the below line we are calling the pop window dialog method to display ui.
                        postData2()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun postData2() {
    val ctx = LocalContext.current



    val email = remember {
        mutableStateOf(TextFieldValue())
    }
    val password = remember {
        mutableStateOf(TextFieldValue())
    }
    val response = remember {
        mutableStateOf("")
    }
    // on below line we are creating a column.
    Column(
        // on below line we are adding a modifier to it
        // and setting max size, max height and max width
        modifier = Modifier

            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        // on below line we are adding vertical
        // arrangement and horizontal alignment.
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on below line we are creating a text
        Text(
            // on below line we are specifying text as
            // Session Management in Android.
            text = "Retrofit POST Request in Android",
            // on below line we are specifying text color.
            color = greenColor,
            fontSize = 20.sp,
            // on below line we are specifying font family
            fontFamily = FontFamily.Default,
            // on below line we are adding font weight
            // and alignment for our text
            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )

        //on below line we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))
        // on below line we are creating a text field for our email.

        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))
        // on below line we are creating a text field for our email.

        TextField(
            // on below line we are specifying value for our email text field.
            value = email.value,
            // on below line we are adding on value change for text field.
            onValueChange = { email.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your email") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we ar adding single line to it.
            singleLine = true,
        )



        TextField(
            // on below line we are specifying value for our email text field.
            value = password.value,
            // on below line we are adding on value change for text field.
            onValueChange = { password.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your password") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we ar adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(10.dp))
        // on below line we are creating a button
        Button(
            onClick = {
                // on below line we are calling make payment method to update data.
                postDataUsingRetrofit(
                    ctx, email,password, response
                )

            },
            // on below line we are adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Post Data", modifier = Modifier.padding(8.dp))
        }
        // on below line we are adding a spacer.
        Spacer(modifier = Modifier.height(20.dp))
        // on below line we are creating a text for displaying a response.
        Text(
            text = response.value,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

private fun postDataUsingRetrofit(
    ctx: Context,
    password: MutableState<TextFieldValue>,
    email: MutableState<TextFieldValue>,
    result: MutableState<String>
) {
    var url = "https://agrifund.tech/api/v1/"
    //https://agrifund.tech/api/v1/auth/register/
    //https://reqres.in/api/
    //http://10.100.2.38:3002/agrifund/v1/
    // on below line we are creating a retrofit
    // builder and passing our base url
    val context = LocalContext
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        // as we are sending data in json format so
        // we have to add Gson converter factory
        .addConverterFactory(GsonConverterFactory.create())
        // at last we are building our retrofit builder.
        .build()
    // below the line is to create an instance for our retrofit api class.
    val retrofitAPI = retrofit.create(RetrofitLogin::class.java)
    // passing data from our text fields to our model class.
    val loginModel = LoginModel(password.value.text,email.value.text)
    // calling a method to create an update and passing our model class.
    val call: Call<LoginModel?>? = retrofitAPI.postData(loginModel)
    // on below line we are executing our method.
    call!!.enqueue(object : Callback<LoginModel?> {
        override fun onResponse(call: Call<LoginModel?>?, response: Response<LoginModel?>) {
            // this method is called when we get response from our api.



          //  Toast.makeText(ctx, "Data posted to API", Toast.LENGTH_SHORT).show()


            // we are getting a response from our body and
            // passing it to our model class.

if (response.isSuccessful){
    Toast.makeText(ctx,"zo ita",Toast.LENGTH_LONG).show()
    ctx.startActivity(Intent(ctx,MainActivity::class.java))
}
    else{
    Toast.makeText(ctx, "zwo bala", Toast.LENGTH_SHORT).show()
            }
            val model: LoginModel? = response.body()
            // on below line we are getting our data from model class
            // and adding it to our string.
            val resp =
                "Response Code : " + response.code()
            // below line we are setting our string to our response.
            result.value = resp

        }

        override fun onFailure(call: Call<LoginModel?>?, t: Throwable) {
            // we get error response from API.
            result.value = "Error found is : " + t.message
        }
    })

}


