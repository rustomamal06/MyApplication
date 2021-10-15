package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener , DialogInterface.OnClickListener{
    private EditText editTextEmail,editTextPassword;
    private Button buttonLogin,buttonSignUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail=findViewById(R.id. editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        buttonLogin=findViewById(R.id.buttonLogin);
        //sets the required button to respond to long click,otherwise it won't
        buttonLogin.setOnLongClickListener(this);
        buttonSignUP=findViewById(R.id.buttonSignUP);

        SharedPreferences sp=getSharedPreferences("settings",MODE_PRIVATE);
        String email=sp.getString("email","");
        String password=sp.getString("password","");

        if(!email.equals("")&&!password.equals(""))
        {
            editTextEmail.setText(email);
            editTextPassword.setText(password);
        }
    }
    public void login(View view){
        Intent intent= new Intent(this,IntroActivity.class) ;
        if(!editTextEmail.getText().toString().equals("")&&editTextEmail.getText().toString().contains("@")&&editTextEmail.getText().toString().contains("."))
        {
            //saving email and password of user in a local file for future use
            //create sp
            SharedPreferences sp=getSharedPreferences("settings",MODE_PRIVATE);

            //open editor for editing
            SharedPreferences.Editor editor=sp.edit();

            //write the wanted settings
            editor.putString("email",editTextEmail.getText().toString());
            editor.putString("password",editTextPassword.getText().toString());

            //save and close file
            editor.commit();

            intent.putExtra("name", editTextEmail.getText().toString());
            startActivity(intent);
        }
    }

    public void SignUP(View view) {
        Intent intent1= new Intent(this,SignUPActivity.class) ;
        startActivity(intent1);
    }

    @Override
    public boolean onLongClick(View view) {
        editTextEmail.setText("");
        editTextPassword.setText("");
        return true;
    }
    public void onBackPressed()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES",this);
        builder.setNegativeButton("NO",this);
        AlertDialog dialog= builder.create();
        dialog.show();
    }
    public void onClick(DialogInterface dialog, int which)
    {
     if(which==dialog.BUTTON_POSITIVE)
     {
         super.onBackPressed();
         dialog.cancel();
     }
     if(which==dialog.BUTTON_NEGATIVE)
     {
         dialog.cancel();
     }
    }

}