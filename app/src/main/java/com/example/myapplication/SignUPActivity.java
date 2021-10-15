package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUPActivity extends AppCompatActivity {
    private EditText editTextfullname,editTextUsername,editTextPhone,editTextDate,editTextPostalAddress;
    private Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upactivity);
        editTextfullname=findViewById(R.id.editTextfullname);
        editTextUsername=findViewById(R.id.editTextUsername);
        editTextDate=findViewById(R.id.editTextAge);
        editTextPostalAddress=findViewById(R.id.editTextPassword;
        buttonSubmit=findViewById(R.id.buttonSubmit);
    }

    public void Submit(View view) {
        Intent intent= new Intent(this,WelcomeActivity.class) ;
        if(!editTextfullname.getText().toString().equals("")&&editTextfullname.getText().toString().contains("@")&&editTextEmailAddress.getText().toString().contains("."))
            intent.putExtra("name",editTextfullname.getText().toString());
        startActivity(intent);
    }
}