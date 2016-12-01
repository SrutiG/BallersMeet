package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ballersmeet.sruti.ballersmeet.R;

import java.util.ArrayList;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Game;

import java.util.concurrent.ExecutionException;

import static android.R.attr.y;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private RecyclerView games_list;
    private com.ballersmeet.sruti.ballersmeet.control.HomeScreenAdapter nearbyAdapter;
    private RecyclerView.LayoutManager nearbyManager;
    private ArrayList<Game> games;
    private MainActivity main;
    Athlete athlete;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout flayout = (FrameLayout) inflater.inflate(R.layout.fragment_home, container, false);
        athlete = (Athlete) getArguments().getSerializable("athlete");

        games = athlete.toArray();
        games_list = (RecyclerView) flayout.findViewById(R.id.games_list);
        nearbyManager = new LinearLayoutManager(getActivity());
        games_list.setLayoutManager(nearbyManager);
        nearbyAdapter = new com.ballersmeet.sruti.ballersmeet.control.HomeScreenAdapter(games, getContext());
        nearbyAdapter.setMain(main);

        games_list.setAdapter(nearbyAdapter);
        return flayout;
    }

    public void setMain(MainActivity main) {
        this.main = main;
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
