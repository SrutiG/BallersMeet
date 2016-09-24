package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ballersmeet.sruti.ballersmeet.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void handleRegisterClick(View view) {
        Intent registerView = new Intent(this, RegisterActivity.class);
        startActivity(registerView);
    }

    public void handleLoginClick(View view) {
        Intent loginView = new Intent(this, LoginActivity.class);
        startActivity(loginView);
    }
}
