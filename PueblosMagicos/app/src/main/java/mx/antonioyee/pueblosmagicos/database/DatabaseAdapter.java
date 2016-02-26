package mx.antonioyee.pueblosmagicos.database;

import android.database.sqlite.SQLiteDatabase;

import mx.antonioyee.pueblosmagicos.application.AppController;

/**
 * Created by antonioyee on 26/02/16.
 */
public class DatabaseAdapter {

    private static DatabaseHelper mDbHelper;
    private static SQLiteDatabase mDb;

    public static boolean openDB(){
        if(mDbHelper != null)
            mDbHelper.close();
        mDbHelper = new DatabaseHelper(AppController.getInstance().getApplicationContext());

        try {
            mDb = mDbHelper.getWritableDatabase();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static SQLiteDatabase getDB(){

        if(mDb == null)
            openDB();

        return mDb;

    }

}
