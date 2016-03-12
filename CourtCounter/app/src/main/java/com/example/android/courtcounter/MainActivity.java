package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView value;
    public int total  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        value = (TextView) findViewById(R.id.value);
    }
    public void free(View view){
        total = 0;
        value.setText(""+total);
    }
    public void more2(View view){
        total += 2;
        value.setText(""+total);
    }
    public void more3(View view){
        total += 3;
        value.setText("" + total);
    }
}
