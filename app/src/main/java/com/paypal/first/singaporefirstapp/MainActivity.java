package com.paypal.first.singaporefirstapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    public static final String TAG = "SingaporeFirstApp-LOG";

    public static final int REQUEST_CODE = 1010;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate invoked.");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doNextClick(View v) {
        Log.i(TAG, "Next View is clicked... handled by XML wired handler");

        if (v == findViewById(R.id.callButton)) {
            Log.i(TAG, "Clicked on Call Button");
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("buttonAction", ButtonAction.Call);
            startActivity(intent);
        } else if (v == findViewById(R.id.browseButton)) {
            Log.i(TAG, "Clicked on Browse Button");
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("buttonAction", ButtonAction.Browse);
            startActivity(intent);
        } else {
            Log.i(TAG, "Clicked on Get Result Button");
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            Bundle bundle = data.getExtras();
            if (resultCode == RESULT_OK) {
                Log.i(TAG, String.format("Result from ThirdActivity: %s", bundle.getSerializable("feedback")));
            } else {
                Log.e(TAG, String.format("Result returned something unusual: %s", bundle.getString("error")));
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onStart() {
        Log.i(TAG, "onStart invoked.");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume invoked.");
        super.onResume();
    }

    @Override
    public void onRestart() {
        Log.i(TAG, "onRestart invoked.");
        super.onRestart();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "onPause invoked.");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop invoked.");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy invoked.");
        super.onDestroy();
    }
}
