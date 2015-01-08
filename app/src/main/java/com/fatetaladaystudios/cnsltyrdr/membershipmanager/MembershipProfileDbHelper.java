package com.fatetaladaystudios.cnsltyrdr.membershipmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cnsltyrdr on 1/8/2015.
 */
public class MembershipProfileDbHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME ="MembershipManager.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MembershipProfileDatabaseContract.MembershipProfile.TABLE_NAME + " (" +
                    MembershipProfileDatabaseContract.MembershipProfile._ID + " INTEGER PRIMARY KEY," +
                    MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_COMPANY_NAME + TEXT_TYPE + COMMA_SEP +
                    MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_PHONE_NUMBER + TEXT_TYPE + COMMA_SEP +
                    MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_WEBSITE_URL + TEXT_TYPE + COMMA_SEP +
                    MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_BARCODE_RAW_DATA + TEXT_TYPE + COMMA_SEP +
                    MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_BARCODE_VALUE + TEXT_TYPE + COMMA_SEP +
                    MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_ERROR_CORRECTION + TEXT_TYPE + COMMA_SEP +
                    MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_PROFILE_ID + TEXT_TYPE  +
            " )";



    public MembershipProfileDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
