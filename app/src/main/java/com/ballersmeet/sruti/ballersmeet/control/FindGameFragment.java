package com.ballersmeet.sruti.ballersmeet.control;

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
import java.util.ArrayList;

public class FindGameFragment extends Fragment {

    Athlete athlete;
    ArrayList<Game> options;
    MainActivity main;
    Button search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity  = (FragmentActivity) super.getActivity();
        RelativeLayout rlLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_find_game, container, false);
        search = (Button) rlLayout.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("athlete", (Serializable) athlete);
                bundle.putSerializable("options", (Serializable) options);
                SearchGamesFragment search = new SearchGamesFragment();
                search.setMain(main);
                search.setArguments(bundle);
                main.setFragment(search);
            }
        });
        athlete = (Athlete) getArguments().getSerializable("athlete");
        options = (ArrayList<Game>) getArguments().getSerializable("options");
        return rlLayout;
    }

    public void setMain(MainActivity main) {
        this.main = main;
    }
}
