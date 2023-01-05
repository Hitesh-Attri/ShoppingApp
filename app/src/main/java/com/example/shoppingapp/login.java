package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                Toast.makeText(login.this, "lgin button clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login.this,NavActivity.class);
                startActivity(intent);
            }
        });



    }
}