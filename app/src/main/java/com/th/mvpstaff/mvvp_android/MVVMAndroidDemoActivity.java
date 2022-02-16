package com.th.mvpstaff.mvvp_android;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.th.mvpstaff.BaseDataActivity;
import com.th.mvpstaff.R;
import com.th.mvpstaff.bean.Account;
import com.th.mvpstaff.databinding.ActivityMvvmAndroidBinding;

/**
 * Should the view communicate with viewModel?
 */
public class MVVMAndroidDemoActivity extends BaseDataActivity {
    private MvvmModelImpl model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmAndroidBinding binding = ActivityMvvmAndroidBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        // how did you release?
        LoginViewModel viewModel = new ViewModelProvider(MVVMAndroidDemoActivity.this).get(LoginViewModel.class);
        viewModel.account.observe(this, account -> {
            binding.setAccount(account);
        });
        binding.setLoginModel(viewModel);

        model = new MvvmModelImpl(viewModel);

        binding.btLogin.setOnClickListener(v -> {
            model.login(viewModel.username.getValue(), viewModel.pwd.getValue());
        });
    }
}
