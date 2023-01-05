package com.example.shoppingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DB1";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CRED = "CredTable";

    // colmns
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    public MyDBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {

        // CREATE TABLE CredTable (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, password TEXT)
        sdb.execSQL( "CREATE TABLE " + TABLE_CRED +
//                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "(" + KEY_NAME + " TEXT PRIMARY KEY , " +
                        KEY_EMAIL + " TEXT, " +
                        KEY_PASSWORD + " TEXT" + ")"
        );

//        SQLiteDatabase database = this.getWritableDatabase();
//
//        database.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int i, int i1) {
        sdb.execSQL("DROP TABLE IF EXISTS " + TABLE_CRED);
        onCreate(sdb);
    }

    public boolean addCreds(String name, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);

        long result = db.insert(TABLE_CRED, null, values);
        if(result==-1)
            return false;
        return true;


    }

    public boolean checkUsername( String username){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM " + TABLE_CRED + " WHERE " + KEY_NAME + " = ?", new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_CRED + " where " + KEY_NAME + " = ? and " + KEY_PASSWORD + " = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public void deleteUser(String username){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CRED, KEY_NAME + " = " + username,null); ==> doubt .. not working
        db.delete(TABLE_CRED, KEY_NAME + " = ? ", new String[]{username});
    }
}
