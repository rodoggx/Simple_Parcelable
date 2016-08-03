package com.example.simpleparseable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    private String jsonString = "[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]";
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> dataArrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Type listType = new TypeToken<List<Student>>() {}.getType();
        Gson gson = new GsonBuilder().create();

        students = gson.fromJson(jsonComplexString, Result.class);

        printList(students);

    }

    public void doMagic(View view) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);


    }
}
