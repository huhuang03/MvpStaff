package com.th.mvpstaff.mvc;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.th.mvpstaff.BaseDataActivity;

public class MvcDemoActivity extends BaseDataActivity implements View {
    private Controller controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new ControllerImpl(this);
        btIncrement.setOnClickListener(view -> {
            controller.handleIncrease();
        });
        btReduce.setOnClickListener(view -> {
            controller.handleReduce();
        });
    }

    @Override
    public void setText(String text) {
        tv.setText(text);
    }
}
