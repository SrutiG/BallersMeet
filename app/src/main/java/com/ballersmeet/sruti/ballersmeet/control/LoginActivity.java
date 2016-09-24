package com.ballersmeet.sruti.ballersmeet.control;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ballersmeet.sruti.ballersmeet.R;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button login;

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
        Log.d("Login", username);
        String password = pass.getText().toString();
        Log.d("Login", password);
        if (password.equals("pass") && username.equals("user")) {
            Intent homeView = new Intent(this, HomeScreenActivity.class);
            startActivity(homeView);
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
