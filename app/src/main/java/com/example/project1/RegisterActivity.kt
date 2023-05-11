package com.example.project1

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_register)
        var etUsername: EditText
        var etPassword: EditText
        var btnRegister: Button


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        findViewById(R.id.etRUserName) as EditText
        findViewById(R.id.etRPassword) as EditText
        findViewById(R.id.btnRegister) as Button

        var etButton = findViewById<Button>(R.id.btnRegister)
        var Name="Ntokozo"
        etButton.setOnClickListener{
            Toast.makeText(this, Name + "_"+ "Has successfully registered!",Toast.LENGTH_LONG).show();

        }



    }
}