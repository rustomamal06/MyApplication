package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUPActivity extends AppCompatActivity {
    private static final String TAG = "FIREBASE" ;
    private EditText editTextfullname,editTextUsername,editTextGmail,editTextAge,editTextPassword;
    private Button buttonSubmit;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upactivity);
        editTextfullname=findViewById(R.id.editTextfullname);
        editTextUsername=findViewById(R.id.editTextUsername);
        editTextGmail=findViewById(R.id.editTextGmail);
        editTextAge=findViewById(R.id.editTextAge);
        editTextPassword=findViewById(R.id.editTextPassword);
        buttonSubmit=findViewById(R.id.buttonSubmit);
        mAuth = FirebaseAuth.getInstance();//gets the instance of the firebase connected to the project
    }

    public void Submit(View view) {
        signup(editTextGmail.getText().toString(),editTextPassword.getText().toString());

    }

    private void signup (String email,String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i=new Intent(SignUPActivity.this,SetTimeActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUPActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

}