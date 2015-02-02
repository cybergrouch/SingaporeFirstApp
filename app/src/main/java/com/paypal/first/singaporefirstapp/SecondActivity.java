package com.paypal.first.singaporefirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.concurrent.Callable;


public class SecondActivity extends ActionBarActivity {

    private Callable<Intent> futureIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final ButtonAction buttonAction = (ButtonAction) bundle.getSerializable("buttonAction");

        futureIntent = new Callable<Intent>() {

            @Override
            public Intent call() throws Exception {
                if (ButtonAction.Call == buttonAction) {
                    return callIntent();
                }
                return browseIntent();
            }
        };
        Log.i(MainActivity.TAG, String.format("Action Passed: %s", buttonAction));
    }

    public void doSecondButtonClick(View v) throws Exception {
        Log.i(MainActivity.TAG, String.format("Second Button is clicked: %s", v.getTag()));
        if (v == findViewById(R.id.actionButton)) {
            startActivity(futureIntent.call());
        } else {
            Log.e(MainActivity.TAG, String.format("No button found: %s", v.getTag()));
        }
    }

    private Intent callIntent() {
        // Call Implicit Intent
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:97365777"));
        return intent;
    }

    private Intent browseIntent() {
        // Browse Implicit Intent
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com"));
        return intent;
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
