package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameView;
    private EditText emailView;
    private EditText passwordView;
    private EditText passwordConfView;
    private Button regbtn;

    private String username, email, password, passwordConf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MyDBHelper myDBHelper = new MyDBHelper(this);

        regbtn = findViewById(R.id.button3);
        usernameView = findViewById(R.id.editTextTextPersonName2);
        emailView = findViewById(R.id.editTextTextEmailAddress);
        passwordView = findViewById(R.id.editTextTextPassword);
        passwordConfView = findViewById(R.id.editTextTextPassword2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registerbtn = findViewById(R.id.button3);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Register Button clicked!", Toast.LENGTH_SHORT).show();

                // extracting text from input fields

                if(validateEmail(emailView)){
                    email = emailView.getText().toString();
                    username = usernameView.getText().toString();
                    password = passwordView.getText().toString();
                    passwordConf = passwordConfView.getText().toString();

                    if(isSamePass(password,passwordConf)){
                        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();

                        // inserting data
                        myDBHelper.addCreds(username, email, password);

                        // text clear
                        clearAll();
//                  clearPassFields();
                    }else{
                        clearPassFields();
                    }

//                  Log.d("helpp", username);

                }else{
                    emailView.getText().clear();
                }
            }
        });

        TextView textView = findViewById(R.id.textViewL);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });
        //        myDBHelper.addCreds("Bunty0", "buntyy0@gmail.com","00000");
    }

    private void clearAll(){
        usernameView.getText().clear();
        emailView.getText().clear();
        passwordView.getText().clear();
        passwordConfView.getText().clear();
    }
    private void clearPassFields(){
        passwordView.getText().clear();
        passwordConfView.getText().clear();
    }

    private boolean validateEmail(EditText email){
        String emailInput = email.getText().toString();
        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
//            Toast.makeText(this, "Valid email", Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    private boolean isSamePass(String pass, String passCnf){
        if(pass.isEmpty() || passCnf.isEmpty()){
            Toast.makeText(this, "Field cant be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(pass.equals(passCnf)){
            return true;
        }
        else{
            Toast.makeText(this, "Password does not match!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}