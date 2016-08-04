package com.example.simpleparseable;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    public static final String NUMBER_KEY = "NUMBER_KEY";

    private String dataJSON = "[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]";

    private ArrayList<Student> students;

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.mEdt1);

        Type listType = new TypeToken<List<Student>>() {
        }.getType();
        Gson gson = new GsonBuilder().create();

        students = gson.fromJson(dataJSON, listType);

        printList(students);
    }

    public void doMagic(View view) {
        int number = Integer.parseInt(mEditText.getText().toString());

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(NUMBER_KEY, number);
        startActivity(intent);
    }

    public void printList(List<Student> students) {
        for (Student student : students) {
            Log.d(TAG, "printList: " + student.name);
        }
    }
}
