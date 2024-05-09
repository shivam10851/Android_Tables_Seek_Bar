package com.example.tableseekbarlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar=findViewById(R.id.seekBar);
        TextView status=findViewById(R.id.textView);
        ListView listView=findViewById(R.id.listView);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        ArrayList<String> list=new ArrayList<>();
        for(int ind=1;ind<=10;ind++){
            int ele=seekBar.getProgress();
            list.add(ele+"x"+ind+"="+ele*ind);
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String mytext="Table of "+i;
                status.setText(mytext);
                list.clear();
                for(int ind=1;ind<=10;ind++){
                    list.add(i+"x"+ind+"="+i*ind);
                }
                arrayAdapter.notifyDataSetChanged();
                listView.setAdapter(arrayAdapter);
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