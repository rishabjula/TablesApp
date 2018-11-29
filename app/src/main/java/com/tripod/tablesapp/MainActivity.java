package com.tripod.tablesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView tableListView;

    void generateTable(int timesTableNumber)
    {
        ArrayList<String> timesTableList = new ArrayList<>();

        for(int j=1; j<=10; j++)
        {
            timesTableList.add(Integer.toString(j * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,timesTableList);
        tableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tableSeekBar = findViewById(R.id.seekBarTable);
        tableListView = findViewById(R.id.tableList);

        int max =20;
        int startingPosition=10;
        tableSeekBar.setMax(max);
        tableSeekBar.setProgress(10);
        generateTable(startingPosition);

        tableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int timesTableNumber;

                if(i<min)
                {
                    timesTableNumber = min;
                    tableSeekBar.setProgress(min);
                }
                else {
                    timesTableNumber=i;
                }
                Log.i("Seekbar value:",Integer.toString(timesTableNumber));

                generateTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
