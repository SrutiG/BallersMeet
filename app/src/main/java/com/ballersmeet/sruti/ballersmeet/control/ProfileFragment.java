package com.ballersmeet.sruti.ballersmeet.control;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;

public class ProfileFragment extends Fragment {

    private Athlete athlete;
    TextView user, skill;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_profile, container, false);
        athlete = (Athlete) getArguments().getSerializable("athlete");
        user = (TextView) rlLayout.findViewById(R.id.userTV);
        skill = (TextView) rlLayout.findViewById(R.id.skillTV);
        String userText = athlete.getFirstName() + " " + athlete.getLastName() + "("
                + athlete.getUsername() + ")";
        user.setText(userText);
        String levelText = ("" + athlete.getLevel());
        skill.setText(levelText);
        return rlLayout;
    }

}
