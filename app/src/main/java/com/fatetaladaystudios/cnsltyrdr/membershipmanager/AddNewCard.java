package com.fatetaladaystudios.cnsltyrdr.membershipmanager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class AddNewCard extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_card);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_card, menu);
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

    public void onClickScanButton(View v){

        BarCodeScannerIntentIntegrator intent = new BarCodeScannerIntentIntegrator(this);
        intent.initiateScan();
        //intent.startActivityForResult(this,1);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
         BarCodeScannerIntentResult scanResult = BarCodeScannerIntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
                String data = scanResult.getContents();

              }
         // else continue with any other code you need in the method

        }
    public void onClickSaveButton(View v){
        MembershipProfileDbHelper membershipProfileDbHelper = new MembershipProfileDbHelper(v.getContext());
        SQLiteDatabase db = membershipProfileDbHelper.getWritableDatabase();
        EditText companyName = (EditText)findViewById(R.id.company_name_input);
        EditText websiteUrl = (EditText)findViewById(R.id.website_url_input);
        EditText phoneNumber = (EditText)findViewById(R.id.phone_number_input);


        ContentValues valuesToInsert = new ContentValues();

        //valuesToInsert.put(MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_BARCODE_RAW_DATA,textField.getText().toString());
        valuesToInsert.put(MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_COMPANY_NAME,companyName.getText().toString());
        valuesToInsert.put(MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_WEBSITE_URL,websiteUrl.getText().toString());
        valuesToInsert.put(MembershipProfileDatabaseContract.MembershipProfile.COLUMN_NAME_PHONE_NUMBER,phoneNumber.getText().toString());

        long newRowId;
        newRowId = db.insert(
                MembershipProfileDatabaseContract.MembershipProfile.TABLE_NAME,
                "null",
                valuesToInsert);

    }
}
