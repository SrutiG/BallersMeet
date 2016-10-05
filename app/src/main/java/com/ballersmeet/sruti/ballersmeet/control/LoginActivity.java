package com.ballersmeet.sruti.ballersmeet.control;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ballersmeet.sruti.ballersmeet.model.Athlete;

import com.ballersmeet.sruti.ballersmeet.R;

import java.io.Serializable;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button login;
    Athlete athlete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user =  (EditText) findViewById(R.id.usernameET);
        pass =  (EditText) findViewById(R.id.passwordET);
        login = (Button) findViewById(R.id.loginBT);
    }


    public void handleLoginClicked(View view) {

        String username = user.getText().toString();
        String password = pass.getText().toString();
        if (password.equals("pass") && username.equals("user")) {
            Intent mainView = new Intent(this, MainActivity.class);
            Athlete athlete = new Athlete("Sruti", "Guhathakurta", "sruti@gatech.edu", username, password);
            mainView.putExtra("athlete", (Serializable) athlete);
            startActivity(mainView);
        } else {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Incorrect Username or Password");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Okay",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }

    public void handleCancelClicked(View view) {
        Intent welcomeView = new Intent(this, WelcomeActivity.class);
        startActivity(welcomeView);
    }
}
