package com.fatetaladaystudios.cnsltyrdr.membershipmanager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickAddCardButton(View v){
        Context context = this;
        Intent addCardIntent = new Intent(context, AddNewCard.class);
        startActivity(addCardIntent);
    }
    public void onClickFindCardButton(View v){
        //new AlertDialog.Builder(this).setMessage("Clicked");
        MembershipProfileDbHelper membershipProfileDbHelper = new MembershipProfileDbHelper(v.getContext());
        //read from db
        SQLiteDatabase db = membershipProfileDbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_COMPANY_NAME,
                MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_PHONE_NUMBER,
                MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_WEBSITE_URL
        };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_COMPANY_NAME + " DESC";

        Cursor c = db.query(
                MembershipProfileDatabaseContract.MembershipProfile.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        c.moveToFirst();
        //String companyName = c.getString(c.getColumnIndex(MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_COMPANY_NAME));

        c.move(2);
        String companyName = c.getString(c.getColumnIndex(MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_COMPANY_NAME));

        //Create a barcode from data


        new AlertDialog.Builder(this).setMessage(companyName).show();
    }
}
