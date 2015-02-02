package com.paypal.first.singaporefirstapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ThirdActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void doFeedbackClick(View v) {
        Intent intent = new Intent();
        if (v == findViewById(R.id.successButton)) {
            intent.putExtra("feedback", Feedback.Success);
            setResult(RESULT_OK, intent);
        } else if (v == findViewById(R.id.failButton)) {
            intent.putExtra("feedback", Feedback.Fail);
            setResult(RESULT_OK, intent);
        } else {
            Log.e(MainActivity.TAG, "Unrecognized button clicked");
            intent.putExtra("error", "Unrecognized button clicked");
            setResult(RESULT_CANCELED, intent);
        }
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third, menu);
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
