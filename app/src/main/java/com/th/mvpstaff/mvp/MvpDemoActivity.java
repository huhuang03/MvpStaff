package com.th.mvpstaff.mvp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.th.mvpstaff.BaseDataActivity;


// https://www.geeksforgeeks.org/mvp-model-view-presenter-architecture-pattern-in-android-with-example/
// https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter
public class MvpDemoActivity extends BaseDataActivity implements Contact.View {
    private Contact.Present mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresentImpl(this);

        btIncrement.setOnClickListener(view -> {
            mPresenter.handleClickIncrease();
        });
        btReduce.setOnClickListener(view -> {
            mPresenter.handleClickRecuse();
        });
    }

    @Override
    public void setText(String text) {
        tv.setText(text);
    }
}
