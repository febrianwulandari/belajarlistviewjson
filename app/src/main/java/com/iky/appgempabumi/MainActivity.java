package com.iky.appgempabumi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Gempa> gempas = GempaUtils.extractGempa();
        ListView gempaListView = findViewById(R.id.listview);
        final GempaAdapter adapter = new GempaAdapter(this, gempas);
        gempaListView.setAdapter(adapter);
    }
}
