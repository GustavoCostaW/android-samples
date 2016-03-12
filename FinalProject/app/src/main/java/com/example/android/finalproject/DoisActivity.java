package com.example.android.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by gustavocostaw on 12/03/16.
 */
public class DoisActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dois);
    }

    public void backActivity(View view){
        finish();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}
