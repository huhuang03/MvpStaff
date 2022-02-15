package com.th.mvpstaff.mvc;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.th.mvpstaff.BaseDataActivity;
import com.th.mvpstaff.bean.Account;

public class MvcDemoActivity extends BaseDataActivity implements View {
    private Controller controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new ControllerImpl(this);
        btLogin.setOnClickListener(v -> controller.handleLogin(
                etAccount.getText().toString(),
                etPwd.getText().toString()
        ));
    }

}
