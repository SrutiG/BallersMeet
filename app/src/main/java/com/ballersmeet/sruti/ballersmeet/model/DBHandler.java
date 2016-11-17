package com.ballersmeet.sruti.ballersmeet.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        String CREATE_GAMES_TABLE = "CREATE TABLE " + TABLE_GAMES + "("  + KEY_GAME + " TEXT AUTOINCREMENT, "+ KEY_LOCATION + " TEXT, " + KEY_DATE + " TEXT, "
                + KEY_CAPACITY + " TEXT, " + KEY_NUM_PLAYERS + " TEXT + PRIMARY KEY " + KEY_GAME + ", FOREIGN KEY(" + KEY_LOCATION +
                ") REFERENCES " + TABLE_LOCATIONS + "(" + KEY_NAME + "))";
        String CREATE_LOCATIONS_TABLE = "CREATE TABLE " + TABLE_LOCATIONS + "(" + KEY_NAME + " TEXT, " + KEY_ADDRESS + " TEXT," +
                KEY_STATE + " TEXT," + KEY_CITY + " TEXT," + KEY_STATE + " TEXT, " + KEY_ZIP + " TEXT, " + KEY_LAT + " TEXT, "
                + KEY_LONG + " TEXT, PRIMARY KEY(" + KEY_ATHLETE + ", " + KEY_GAME + "))";
        String CREATE_PARTICIPATION_TABLE = "CREATE TABLE " + TABLE_PARTICIPATION + "(" + KEY_ATHLETE + " TEXT," +
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

    public void getAthletebyUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
    }
}
