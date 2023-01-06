package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditUser extends AppCompatActivity {

    private EditText usernameView;
    private String username;
    private Button deletebtn;
    private Button gotoRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        usernameView =findViewById(R.id.editusername);
        deletebtn = findViewById(R.id.removeUser);
        gotoRegBtn = findViewById(R.id.gotoReg);

        MyDBHelper myDBHelper = new MyDBHelper(this);


        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameView.getText().toString();
                Boolean checkUser = myDBHelper.checkUsername(username);
                if(checkUser == true){
                    myDBHelper.deleteUser(username);
                    usernameView.getText().clear();
                    Toast.makeText(EditUser.this, "User Deleted Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(EditUser.this, "User Doesn't Exist!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        gotoRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditUser.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}