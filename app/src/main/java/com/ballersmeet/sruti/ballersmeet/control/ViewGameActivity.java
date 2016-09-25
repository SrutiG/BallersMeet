package com.ballersmeet.sruti.ballersmeet.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Game;

public class ViewGameActivity extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_game);
    }
}
