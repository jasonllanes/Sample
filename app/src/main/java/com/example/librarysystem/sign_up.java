package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity implements View.OnClickListener {

    AccountDatabase accountDatabase;
    EditText etName,etEmail,etPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        accountDatabase = new AccountDatabase(this);


        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);


        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSignUp:
                if(accountDatabase.addAccount(etName.getText().toString(),etEmail.getText().toString(),etPassword.getText().toString()) == true){
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}