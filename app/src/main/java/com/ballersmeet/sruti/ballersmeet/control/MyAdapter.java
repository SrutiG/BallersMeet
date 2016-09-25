package com.ballersmeet.sruti.ballersmeet.control;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Game;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Sruti on 9/24/16.
 */

class MyAdapter extends ArrayAdapter<Game>{
    public MyAdapter(Context context, ArrayList<Game> games) {
        super(context, R.layout.row_layout, games);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.row_layout, parent, false);
        Game game = getItem(position);
        String location = game.getLocation().toString();
        String numText = "" + (position+1);
        String date = game.getDay();
        String time = game.getTime();
        TextView numTV = (TextView)theView.findViewById(R.id.numTV);
        TextView locTV = (TextView)theView.findViewById(R.id.gameLocTV);
        TextView dateTV = (TextView)theView.findViewById(R.id.dateTV);
        TextView timeTV = (TextView) theView.findViewById(R.id.timeTV);
        numTV.setText(numText);
        locTV.setText(location);
        dateTV.setText(date);
        timeTV.setText(time);

        return theView;

    }
}
