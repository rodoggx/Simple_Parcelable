package com.example.simpleparseable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mTextView = (TextView) findViewById(R.id.dtxt1);

        int number = getIntent().getIntExtra(MainActivity.NUMBER_KEY, -1);

        mTextView.setText(String.valueOf(number));
    }
}
