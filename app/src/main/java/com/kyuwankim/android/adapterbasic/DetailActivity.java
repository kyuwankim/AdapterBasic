package com.kyuwankim.android.adapterbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.kyuwankim.android.adapterbasic.ListActivity.DATA_KEY;

public class DetailActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv = (TextView) findViewById(R.id.tv_detail);

        // Activity에서 넘어온 값 처리하기
        // 1. intent를 꺼낸다
        Intent intent = getIntent();
        // 2. 값의 묶음인 bundle을 꺼낸다
        Bundle bundle = intent.getExtras();
        String result = "";
        // 3. bundle 이 있는지 유효성 검사를 한다
        if (bundle != null) {
            // 3.1 bundle이 있으면 값을 꺼내서 변수에 담는다
            result = bundle.getString(DATA_KEY);

        }

        tv.setText(result);
    }
}
