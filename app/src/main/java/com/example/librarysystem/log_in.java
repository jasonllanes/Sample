package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class log_in extends AppCompatActivity implements View.OnClickListener {

    AccountDatabase accountDatabase;
    EditText etEmail,etPassword;
    Button btnLogIn,btnSignUp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        accountDatabase = new AccountDatabase(this);



        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);


        btnLogIn = findViewById(R.id.btnLogIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnLogIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);



        String name = getIntent().getStringExtra("name");



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogIn:
                if(accountDatabase.checkUser(etEmail.getText().toString(),etPassword.getText().toString())){
                    Toast.makeText(this, "Welcome User!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(log_in.this,home.class);
                    startActivity(i);
                }else{
                    Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnSignUp:
                Intent i = new Intent(log_in.this,sign_up.class);
                startActivity(i);
                break;
        }
    }



}