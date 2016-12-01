package com.ballersmeet.sruti.ballersmeet.control;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ballersmeet.sruti.ballersmeet.R;

import java.io.Serializable;

public class WelcomeActivity extends Activity {

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
