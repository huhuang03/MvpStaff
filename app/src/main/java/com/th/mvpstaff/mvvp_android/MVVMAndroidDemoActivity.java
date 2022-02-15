package com.th.mvpstaff.mvvp_android;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

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

class LoginService {
    private static LoginService _inst;

    public static LoginService inst() {
        if (_inst == null) {
            synchronized(LoginService.class) {
                if (_inst == null) {
                    _inst = new LoginService();
                }
            }
        }
        return _inst;
    }

    public Account login(String username, String pwd) {
        return new Account(username, pwd);
    }
}

/**
 * Should the view communicate with viewModel?
 */
public class MVVMAndroidDemoActivity extends BaseDataActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmAndroidBinding binding = ActivityMvvmAndroidBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        LoginViewModel viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLoginModel(viewModel);

        viewModel.account.observe(this, account -> {
            binding.setAccount(account);
        });

        binding.btLogin.setOnClickListener(v -> {
            Account account = LoginService.inst().login(viewModel.username.getValue(), viewModel.pwd.getValue());
            viewModel.account.setValue(account);
        });
    }
}
