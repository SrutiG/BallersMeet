package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;

import java.io.Serializable;

public class ProfileActivity extends AppCompatActivity {

    private Athlete athlete;
    TextView user, skill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
        user = (TextView) findViewById(R.id.userTV);
        skill = (TextView) findViewById(R.id.skillTV);
        String userText = athlete.getFirstName() + " " + athlete.getLastName() + "("
                + athlete.getUsername() + ")";
        user.setText(userText);
        String levelText = ("" + athlete.getLevel());
        skill.setText(levelText);

    }

    public void handleFindClicked(View view) {
        Intent findView = new Intent(this, FindGame.class);
        findView.putExtra("athlete", (Serializable) athlete);
        startActivity(findView);
    }

    public void handleProfileClicked(View view) {
        Intent profileView = new Intent(this, ProfileActivity.class);
        profileView.putExtra("athlete", (Serializable) athlete);
        startActivity(profileView);
    }

    public void handleStartClicked(View view) {
        Intent startView = new Intent(this, StartGameActivity.class);
        startView.putExtra("athlete", (Serializable) athlete);
        startActivity(startView);
    }

    public void handleImageClicked(View view) {
        Intent viewHome = new Intent(this, HomeScreenActivity.class);
        viewHome.putExtra("athlete", (Serializable)athlete);
        startActivity(viewHome);
    }
}
