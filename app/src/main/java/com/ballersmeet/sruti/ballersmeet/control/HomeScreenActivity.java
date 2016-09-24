package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;


import com.ballersmeet.sruti.ballersmeet.R;

import java.io.Serializable;

public class HomeScreenActivity extends AppCompatActivity {

    Athlete athlete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Athlete a = (Athlete) getIntent().getExtras().getSerializable("athlete");*/
        setContentView(R.layout.activity_home_screen);
    }

    public void handleFindClicked(View view) {
        Intent findView = new Intent(this, FindGame.class);
        startActivity(findView);
    }

}
