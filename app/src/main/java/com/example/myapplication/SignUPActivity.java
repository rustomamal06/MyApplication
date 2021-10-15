package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUPActivity extends AppCompatActivity {
    private EditText editTextEmailAddress,editTextPassword,editTextPhone,editTextDate,editTextPostalAddress;
    private Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upactivity);
        editTextEmailAddress=findViewById(R.id. editTextEmailAddress);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextPhone=findViewById(R.id.editTextPhone);
        editTextDate=findViewById(R.id.editTextDate);
        editTextPostalAddress=findViewById(R.id.editTextPostalAddress);
        buttonSubmit=findViewById(R.id.buttonSubmit);
    }

    public void Submit(View view) {
        Intent intent= new Intent(this,WelcomeActivity.class) ;
        if(!editTextEmailAddress.getText().toString().equals("")&&editTextEmailAddress.getText().toString().contains("@")&&editTextEmailAddress.getText().toString().contains("."))
            intent.putExtra("name",editTextEmailAddress.getText().toString());
        startActivity(intent);
    }
}