package com.th.mvpstaff;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseDataActivity extends AppCompatActivity {
    protected TextView tv;
    protected Button btIncrement;
    protected Button btReduce;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_data);
        tv = findViewById(R.id.tv);
        btIncrement = findViewById(R.id.btIncrease);
        btReduce = findViewById(R.id.btReduce);
    }

}
