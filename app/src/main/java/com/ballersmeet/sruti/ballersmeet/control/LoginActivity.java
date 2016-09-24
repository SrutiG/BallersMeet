package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ballersmeet.sruti.ballersmeet.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void handleLoginClick(View view) {
        final EditText user = (EditText) findViewById(R.id.usernameET);
        String username = user.getText().toString();
        System.out.println(username);
        final EditText pass = (EditText) findViewById(R.id.passwordET);
        /**String password = pass.getText().toString();
        System.out.println(password);
        if (username == "user" && password == "pass") {**/
            Intent homeView = new Intent(this, HomeScreenActivity.class);
            startActivity(homeView);
        /**} else {
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
        **/
    }

    public void handleCancelClick(View view) {
        Intent welcomeView = new Intent(this, WelcomeActivity.class);
        startActivity(welcomeView);
    }
}
