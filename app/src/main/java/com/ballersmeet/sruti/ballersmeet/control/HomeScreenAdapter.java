package com.ballersmeet.sruti.ballersmeet.control;

import android.support.v7.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Game;
import com.ballersmeet.sruti.ballersmeet.model.Location;
import com.ballersmeet.sruti.ballersmeet.control.ViewGameFragment;
import com.ballersmeet.sruti.ballersmeet.R;

import com.ballersmeet.sruti.ballersmeet.control.MainActivity;
import com.ballersmeet.sruti.ballersmeet.control.ProfileFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static android.R.attr.id;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.ballersmeet.sruti.ballersmeet.R.id.players_needed;


/**
 * Created by Sruti on 11/5/16.
 */

public class HomeScreenAdapter extends RecyclerView.Adapter<HomeScreenAdapter.MyViewHolder> {

    private ArrayList<Game> games;
    private Context context;
    private MainActivity main;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView cool_logo;
        private TextView name_nearby;
        private TextView name_location;
        private TextView date;
        private TextView time;
        private TextView players_needed;
        private LinearLayout game_view;

        public MyViewHolder(View view) {
            super(view);
            cool_logo = (ImageView) view.findViewById(R.id.cool_logo);
            name_location = (TextView) view.findViewById(R.id.name_location);
            date = (TextView) view.findViewById(R.id.date);
            time = (TextView) view.findViewById(R.id.time);
            players_needed = (TextView) view.findViewById(R.id.players_needed);
            game_view = (LinearLayout) view.findViewById(R.id.game_view);
        }

    }

    public void setMain(MainActivity main) {
        this.main = main;
    }

    public HomeScreenAdapter(ArrayList<Game> games, Context context) {
        this.games = games;
        this.context = context;
    }

    @Override
    public HomeScreenAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_item, parent, false);

        return new HomeScreenAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HomeScreenAdapter.MyViewHolder holder, int position) {
        Game game = games.get(position);
        final int index = position;
        holder.name_location.setText(game.getLocation().toString());
        holder.date.setText(game.getDay());
        holder.time.setText(game.getTime());
        holder.players_needed.setText("Players needed: " + (game.getCapacity() - game.getNumplayers()));
        final ViewGameFragment viewGame = new ViewGameFragment();
        holder.game_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game passGame = games.get(index);
                Bundle bundle = new Bundle();
                bundle.putSerializable("game", (Serializable) passGame);
                viewGame.setArguments(bundle);
                viewGame.setMain(main);
                main.setFragment(viewGame);

            }
        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }
}
