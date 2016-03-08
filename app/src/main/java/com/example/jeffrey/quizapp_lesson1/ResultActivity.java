package com.example.jeffrey.quizapp_lesson1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        listView = (ListView) findViewById(R.id.result_list_view);
        Intent i = getIntent();
        if (i != null) {
            ArrayList<String> result = i.getStringArrayListExtra("results");
            System.out.println(result);
            //Log.d("Debug arraylist",result.get(0));
            listViewAdapter = new ArrayAdapter<>(this, R.layout.result_list_item, R.id.result_text_view, result);
            listView.setAdapter(listViewAdapter);
        }

    }
}
