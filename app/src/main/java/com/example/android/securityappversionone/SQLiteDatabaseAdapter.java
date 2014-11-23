package com.example.android.securityappversionone;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Eric on 11/22/2014.
 */
public class SQLiteDatabaseAdapter {

    SQLiteHelper helper;
    public SQLiteDatabaseAdapter(Context context){
        helper = new SQLiteHelper(context);
    }

    public long insertData(String name, String system){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHelper.NAME,name);
        contentValues.put(SQLiteHelper.SYSTEM,system);
        long id = db.insert(SQLiteHelper.TABLE_NAME,null,contentValues);
        return id;
    }


    static class SQLiteHelper extends SQLiteOpenHelper {
        private static final String TAG = "SQLiteDatabaseAdapter";
        private static final String DATABASE_NAME = "edatabase.db";
        private static final String TABLE_NAME = "PROJECTS";
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final String SYSTEM = "System";
        private static final int DATABASE_VERSION = 4;
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + UID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), " + SYSTEM + " VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;


        public SQLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            Log.d(TAG,"Constructor called");

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
            Log.d(TAG, "onCreate() called");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "onUpgrade() called");
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }
    }




}
