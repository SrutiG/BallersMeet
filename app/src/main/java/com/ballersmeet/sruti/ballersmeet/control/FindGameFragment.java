package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;

public class FindGameFragment extends Fragment {

    Athlete athlete;
    ArrayList<Game> options;
    MainActivity main;
    Button search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.activity_find_game, container, false);
        athlete = (Athlete) getArguments().getSerializable("athlete");
        options = (ArrayList<Game>) getArguments().getSerializable("options");
        return rlLayout;
    }

    public void setMain(MainActivity main) {
        this.main = main;
    }

    public void handleSearch(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("athlete", (Serializable) athlete);
        bundle.putSerializable("options", (Serializable) options);
        SearchGamesFragment search = new SearchGamesFragment();
        search.setArguments(bundle);
        main.setFragment(search);

    }
}
