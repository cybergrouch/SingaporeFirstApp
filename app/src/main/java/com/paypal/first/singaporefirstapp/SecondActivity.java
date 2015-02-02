package com.paypal.first.singaporefirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void doSecondButtonClick(View v) {
        Log.i(MainActivity.TAG, String.format("Second Button is clicked: %s", v.getTag()));
        if (v == findViewById(R.id.callButton)) {
            call();
        } else if(v == findViewById(R.id.browseButton)) {
            browse();
        } else {
            Log.e(MainActivity.TAG, String.format("No button found: %s", v.getTag()));
        }
    }

    private void call() {
        // Call Implicit Intent
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:97365777"));
        startActivity(intent);
    }

    private void browse() {
        // Browse Implicit Intent
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com"));
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
}
