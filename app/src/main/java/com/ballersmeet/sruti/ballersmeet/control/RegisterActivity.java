package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Sruti on 9/24/16.
 */
public class RegisterActivity extends AppCompatActivity {

    EditText fn, ln, user, email, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fn = (EditText) findViewById(R.id.firstNameET);
        ln = (EditText) findViewById(R.id.lastNameET);
        user = (EditText) findViewById(R.id.usernameRET);
        email = (EditText) findViewById(R.id.emailET);
        pw = (EditText) findViewById(R.id.passwordR);
    }

    public void handleCancelClick(View view) {
        Intent welcomeView = new Intent(this, WelcomeActivity.class);
        startActivity(welcomeView);
    }

    public void handleRegisterClicked(View view) {
        String firstName = fn.getText().toString();
        String lastName = ln.getText().toString();
        String username = user.getText().toString();
        String emailAddress = email.getText().toString();
        String password = pw.getText().toString();
        Athlete athlete = new Athlete(firstName, lastName, emailAddress, username, password);
        athlete.setGames(new HashSet<Game>());
        Intent mainView = new Intent(this, MainActivity.class);
        mainView.putExtra("athlete", (Serializable) athlete);
        startActivity(mainView);
    }
}
