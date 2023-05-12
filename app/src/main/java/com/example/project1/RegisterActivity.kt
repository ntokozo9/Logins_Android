package com.example.project1

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button
import android.widget.EditText;
import android.widget.TextView
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

lateinit var etUsername: EditText
lateinit var etPassword: EditText
private lateinit var Username: String
private lateinit var Password: String
class RegisterActivity : AppCompatActivity() {


    private lateinit var btnRegister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        //setContentView(R.layout.activity_register)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        etUsername=findViewById<EditText>(R.id.etRUserName)
        etPassword=findViewById<EditText>(R.id.etRPassword)
        var register =findViewById(R.id.btnRegister) as Button

        this.findViewById<TextView>(R.id.tvLoginLink).setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }




        register.setOnClickListener {
            //var Name = "Ntokozo"
            //  Toast.makeText(this, Name + "_"+ "Has successfully registered!",Toast.LENGTH_LONG).show();
            registerUser()
        }
    }

    private fun registerUser() {
//        TODO("Not yet implemented")
        val userName: String = etUsername.getText().toString().trim()
        val password: String = etPassword.getText().toString().trim()
        if (userName.isEmpty()) {
            etUsername.error = "Username is required"
            etUsername.requestFocus()
            return
        } else if (password.isEmpty()) {
            etPassword.error = "Password is required"
            etPassword.requestFocus()
            return
        }

        val call: Call<ResponseBody> = RetrofitClient
            .getInstance()
            .api
            .createUser(User(userName, password))
        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                var s = ""
                try {
                    s = response.body()!!.string()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                if (s == "SUCCESS") {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Successfully registered. Please login",
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                } else {
                    Toast.makeText(this@RegisterActivity, "User already exists!", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
//fun onFailure(call: Call<ResponseBody?>, t: Throwable) {



