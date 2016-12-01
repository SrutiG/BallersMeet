package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.*;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class FindGameFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    Athlete athlete;
    ArrayList<Game> options;
    MainActivity main;
    Button search;
    private GoogleMap mMap;
    private Marker crc;
    private Marker peters;
    private Marker pike;
    private Marker loc;
    private Date date;
    private static final LatLng CRC = new LatLng(33.775915, -84.403926);
    private static final LatLng PETERS = new LatLng(33.775269, -84.393539);
    private static final LatLng PIKE = new LatLng(33.776774, -84.395269);



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

    // This event is triggered soon after onCreateView().
    // onViewCreated() is only called if the view returned from onCreateView() is non-null.
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        insertNestedFragment();
    }

    // Embeds the child fragment dynamically
    private void insertNestedFragment() {
        Fragment childFragment = new MapFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.container, childFragment).commit();
    }

    public void onMapReady(GoogleMap map) {
        mMap = map;

        // Add some markers to the map, and add a data object to each marker.
        crc = mMap.addMarker(new MarkerOptions()
                .position(CRC)
                .title("CRC"));
        crc.setTag(0);

        peters = mMap.addMarker(new MarkerOptions()
                .position(PETERS)
                .title("Peters Parking Deck"));
        peters.setTag(0);

        pike = mMap.addMarker(new MarkerOptions()
                .position(PIKE)
                .title("Pi Kappa Alpha"));
        pike.setTag(0);

        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(33.779243, -84.396835), 14));
    }

    /** Called when the user clicks a marker. */
    @Override
    public boolean onMarkerClick(final Marker marker) {

        // Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();

        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(super.getActivity(), marker.getTitle() + " has been clicked.", Toast.LENGTH_SHORT).show();
            loc = marker;
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }

    public void handleCreateGameClicked(View view) {
        Location gameloc = new Location(loc.getTitle(), loc.getPosition().toString());
        Game newGame = new Game(6, date, gameloc);
        Intent added = new Intent(super.getActivity(), GameAdded.class);
        added.putExtra("game", (Serializable) newGame);
        added.putExtra("athlete", (Serializable) athlete);
        startActivity(added);
    }

    public void setMain(MainActivity main) {
        this.main = main;
    }
}
