package com.fatetaladaystudios.cnsltyrdr.membershipmanager;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


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
}
