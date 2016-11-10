package com.ballersmeet.sruti.ballersmeet.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sruti on 11/10/16.
 */

public class AthleteDataAccessor extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ballerzMeet";
    private static final String TABLE_ATHLETES = "athletes";
    private static final String KEY_FIRSTNAME = "firstname";
    private static final String KEY_LASTNAME = "lastname";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    public AthleteDataAccessor(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ATHLETES_TABLE = "CREATE TABLE " + TABLE_ATHLETES + "("
                + KEY_FIRSTNAME + " TEXT," + KEY_LASTNAME + " TEXT,"
                + KEY_EMAIL + " TEXT," + KEY_LEVEL + " INTEGER," + KEY_USERNAME + " TEXT PRIMARY KEY," +
                KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_ATHLETES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATHLETES);
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

}
