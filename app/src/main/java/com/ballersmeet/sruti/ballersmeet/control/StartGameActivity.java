package com.ballersmeet.sruti.ballersmeet.control;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ballersmeet.sruti.ballersmeet.R;
import com.ballersmeet.sruti.ballersmeet.model.Athlete;
import com.ballersmeet.sruti.ballersmeet.model.Location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ballersmeet.sruti.ballersmeet.model.Game;

import java.io.Serializable;
import java.util.Date;

import static com.ballersmeet.sruti.ballersmeet.R.id.calendarView;
import static com.ballersmeet.sruti.ballersmeet.R.id.numberPicker;

public class StartGameActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private Athlete athlete;
    private Game game;
    private GoogleMap mMap;
    private Marker crc;
    private Marker peters;
    private Marker pike;
    private Marker loc;
    private Date date;
    private int numPlayers;
    private static final LatLng CRC = new LatLng(33.775915, -84.403926);
    private static final LatLng PETERS = new LatLng(33.775269, -84.393539);
    private static final LatLng PIKE = new LatLng(33.776774, -84.395269);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        athlete = (Athlete) getIntent().getExtras().getSerializable("athlete");
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        date = new Date();
        CalendarView v = (CalendarView)findViewById(R.id.calendarView);
        v.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = new Date( year, month, dayOfMonth );
            }//met
        });
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                date.setHours(hourOfDay);
                date.setMinutes(minute);
            }
        });
        numPlayers = 0;
        NumberPicker np = (NumberPicker)findViewById(R.id.numberPicker);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                numPlayers = i2;
            }
        });
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

    public void handleImageClicked(View view) {
        Intent viewHome = new Intent(this, HomeScreenActivity.class);
        viewHome.putExtra("athlete", (Serializable)athlete);
        startActivity(viewHome);
    }

    public void handleStartClicked(View view) {
        Intent startView = new Intent(this, StartGameActivity.class);
        startView.putExtra("athlete", (Serializable) athlete);
        startActivity(startView);
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
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked.",
                    Toast.LENGTH_SHORT).show();
            loc = marker;
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }

    public void handleStartGameClick(View view) {
        Location gameloc = new Location(loc.getTitle());
        Game newGame = new Game(6, date, gameloc);
        Intent added = new Intent(this, GameAdded.class);
        added.putExtra("game", (Serializable) newGame);
        added.putExtra("athlete", (Serializable) athlete);
        startActivity(added);
    }
}
