package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText usernameView, passwordView;
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameView = findViewById(R.id.editTextTextEmailAddress);
        passwordView = findViewById(R.id.editTextTextPassword);

        TextView textView = findViewById(R.id.newuser);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnLogin = findViewById(R.id.loginbtn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usernameView.getText().toString();
                String password = passwordView.getText().toString();

                if(user.equals("") || password.equals("")){
                    Toast.makeText(login.this, "Enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean checkUser = myDBHelper.checkusernamepassword(user,password);
                    if( checkUser == true){
                        Toast.makeText(login.this, "Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login.this, AfterLogin.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(login.this,"Invalid Credentials! ", Toast.LENGTH_SHORT).show();
                        usernameView.getText().clear();
                        passwordView.getText().clear();
                    }
                }
            }
        });
    }

}