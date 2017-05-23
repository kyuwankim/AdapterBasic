package com.kyuwankim.android.adapterbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int LISTVIEW = 1;
    final int GRIDVIEW = 2;
    final int RECYCLERVIEW = 3;
    final int CUSTOM = 4;

    String datas[] = {"선택", "ListView", "GridView", "RecyclerView", "Custom"};

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        // List뷰에 데이터를 연결하기위한 순서
        // 1. 데이터 정의
        // datas로 정의함
        // 2. 아답터 생성
        // ArrayAdapter 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);

        // 3. 뷰에 아답터 연결
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case LISTVIEW:
                        intent = new Intent(MainActivity.this, ListActivity.class);
                        Toast.makeText(MainActivity.this, datas[position], Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        break;

                    case GRIDVIEW:
                        intent = new Intent(MainActivity.this, GridActivity.class);
                        startActivity(intent);
                        break;

                    case RECYCLERVIEW:
                        intent = new Intent(MainActivity.this, RecyclerActivity.class);
                        startActivity(intent);
                        break;

                    case CUSTOM:
                        intent = new Intent(MainActivity.this, CustomListActivity.class);
                        startActivity(intent);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
