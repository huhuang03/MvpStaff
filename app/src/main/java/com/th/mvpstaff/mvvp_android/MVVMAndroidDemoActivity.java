package com.th.mvpstaff.mvvp_android;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.th.mvpstaff.BaseDataActivity;

/**
 * Should the view communicate with viewModel?
 */
public class MVVMAndroidDemoActivity extends BaseDataActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CountViewModel model = new ViewModelProvider(this).get(CountViewModel.class);
        model.getCount().observe(this, count -> {
            tv.setText(count + "");
        });
        btIncrement.setOnClickListener(v -> {
            model.getCount().increment();
        });
        btReduce.setOnClickListener(v -> {
            model.getCount().decrement();
        });
    }
}
