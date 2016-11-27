package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.google.android.gms.vision.text.Text;

public class ProfileFragment extends Fragment {

    private Athlete athlete;
    TextView user, username;
    TextView skill;
    Button logoutBT;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_profile, container, false);
        athlete = (Athlete) getArguments().getSerializable("athlete");
        user = (TextView) rlLayout.findViewById(R.id.userTV);
        skill = (TextView) rlLayout.findViewById(R.id.skillTV);
        username = (TextView) rlLayout.findViewById(R.id.username);
        logoutBT = (Button) rlLayout.findViewById(R.id.logoutBT);
        logoutBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcomeView = new Intent(getActivity(), WelcomeActivity.class);
                startActivity(welcomeView);
            }
        });

        user.setText(athlete.getFirstName() + " " + athlete.getLastName());
        username.setText(athlete.getUsername());
        String levelText = ("" + athlete.getLevel());
        skill.setText(levelText);
        return rlLayout;
    }


}
