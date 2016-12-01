package com.ballersmeet.sruti.ballersmeet.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static android.R.attr.id;
import static android.provider.Contacts.SettingsColumns.KEY;
import static com.ballersmeet.sruti.ballersmeet.R.id.username;

/**
 * Created by Sruti on 10/16/16.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ballerzMeet";
    private static final String TABLE_ATHLETES = "athletes";
    private static final String KEY_FIRSTNAME = "firstname";
    private static final String KEY_LASTNAME = "lastname";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private static final String TABLE_GAMES = "games";
    private static final String KEY_GAME = "gameid";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_DATE = "date";
    private static final String KEY_CAPACITY = "capacity";
    private static final String KEY_NUM_PLAYERS = "num_players";

    private static final String TABLE_LOCATIONS = "locations";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_CITY = "city";
    private static final String KEY_STATE = "state";
    private static final String KEY_ZIP = "zip";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LONG = "long";

    private static final String TABLE_PARTICIPATION = "participation";
    private static final String KEY_ATHLETE = "username";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ATHLETES_TABLE = "CREATE TABLE " + TABLE_ATHLETES + "("
        + KEY_FIRSTNAME + " TEXT," + KEY_LASTNAME + " TEXT,"
        + KEY_EMAIL + " TEXT," + KEY_LEVEL + " INTEGER," + KEY_USERNAME + " TEXT PRIMARY KEY," +
                KEY_PASSWORD + " TEXT" + ")";
        String CREATE_GAMES_TABLE = "CREATE TABLE " + TABLE_GAMES + "("  + KEY_GAME + " TEXT PRIMARY KEY, "+ KEY_LOCATION + " TEXT, " + KEY_DATE + " TEXT, "
                + KEY_CAPACITY + " TEXT, " + KEY_NUM_PLAYERS + " TEXT, FOREIGN KEY(" + KEY_LOCATION +
                ") REFERENCES " + TABLE_LOCATIONS + "(" + KEY_NAME + "))";
        String CREATE_LOCATIONS_TABLE = "CREATE TABLE " + TABLE_LOCATIONS + "(" + KEY_NAME + " TEXT, " + KEY_ADDRESS + " TEXT, " +
                KEY_STATE + " TEXT, " + KEY_CITY + " TEXT, " + KEY_ZIP + " TEXT, " + KEY_LAT + " TEXT, "
                + KEY_LONG + " TEXT, PRIMARY KEY(" + KEY_NAME + "))";
        String CREATE_PARTICIPATION_TABLE = "CREATE TABLE " + TABLE_PARTICIPATION + "(" + KEY_ATHLETE + " TEXT, " +
                KEY_GAME + " TEXT, PRIMARY KEY(" + KEY_ATHLETE + ", " + KEY_GAME + ") FOREIGN KEY(" + KEY_GAME +
                ") REFERENCES " + TABLE_GAMES + "(" + KEY_GAME + "), FOREIGN KEY(" + KEY_ATHLETE +
                ") REFERENCES " + TABLE_ATHLETES + "(" + KEY_USERNAME + "))";
        db.execSQL(CREATE_ATHLETES_TABLE);
        db.execSQL(CREATE_GAMES_TABLE);
        db.execSQL(CREATE_LOCATIONS_TABLE);
        db.execSQL(CREATE_PARTICIPATION_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATHLETES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAMES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARTICIPATION);
        onCreate(db);
    }

    public void addAthlete(Athlete athlete) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, athlete.getFirstName());
        values.put(KEY_LASTNAME, athlete.getLastName());
        values.put(KEY_EMAIL, athlete.getEmail());
        values.put(KEY_USERNAME, athlete.getUsername());
        values.put(KEY_PASSWORD, athlete.getPassword());
        db.insert(TABLE_ATHLETES, null, values);
        db.close();
    }

    public void addGame(Game game) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LOCATION, game.getLocation().getName());
        values.put(KEY_DATE, game.getDate().toString());
        values.put(KEY_CAPACITY, game.getCapacity());
        values.put(KEY_NUM_PLAYERS, game.getNumplayers());
        db.insert(TABLE_GAMES, null, values);
        db.close();
    }

    public void addLocation(Location location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, location.getName());
        values.put(KEY_ADDRESS, location.getAddress());
        values.put(KEY_CITY, location.getCity());
        values.put(KEY_STATE, location.getState());
        values.put(KEY_ZIP, location.getZip());
        values.put(KEY_LAT, location.getLatitude());
        values.put(KEY_LONG, location.getLongitude());
        db.insert(TABLE_LOCATIONS, null, values);
        db.close();
    }

    public void addParticipant(String username, int gameid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, username);
        values.put(KEY_GAME, gameid);
        db.insert(TABLE_PARTICIPATION, null, values);
        db.close();
    }

    public Athlete getAthletebyUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_ATHLETES + " WHERE " + KEY_USERNAME + " = '" + username + "';";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null)
            cursor.moveToFirst();
        Athlete athlete = new Athlete(cursor.getString(0),
                cursor.getString(1), cursor.getString(2), username, cursor.getString(5));
        return athlete;
    }

    public List<Game> getAthleteGames(String username) {
        List<Game> games = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PARTICIPATION, new String[] {KEY_GAME}, KEY_ATHLETE + "=?",
                new String[] { String.valueOf(username) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        while (cursor.moveToNext()) {
            Game game = getGame(Integer.parseInt(cursor.getString(0)));
            games.add(game);
        }
        return games;
    }

    public Game getGame(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_GAMES, new String[] { KEY_GAME,
                        KEY_LOCATION, KEY_DATE, KEY_CAPACITY, KEY_NUM_PLAYERS }, KEY_GAME + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Game game = new Game(Integer.parseInt(cursor.getString(4)),
                new Date(cursor.getString(2)), getLocation(cursor.getString(1)));
        return game;
    }

    public Location getLocation(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LOCATIONS, new String[] { KEY_NAME,
                        KEY_ADDRESS, KEY_STATE, KEY_CITY, KEY_ZIP, KEY_LAT, KEY_LONG }, KEY_NAME + "=?",
                new String[] { String.valueOf(name) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Location location = new Location(cursor.getString(0),
                cursor.getString(1), Integer.parseInt(cursor.getString(4)), cursor.getString(3), cursor.getString(2), cursor.getString(5), cursor.getString(6));
        return location;
    }
}
