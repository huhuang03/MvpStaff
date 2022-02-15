package com.th.mvpstaff.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.th.mvpstaff.BaseDataActivity;
import com.th.mvpstaff.bean.Account;


// https://www.geeksforgeeks.org/mvp-model-view-presenter-architecture-pattern-in-android-with-example/
// https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter
public class MvpDemoActivity extends BaseDataActivity implements View {
    private Present mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresentImpl(this);

        btLogin.setOnClickListener(v ->
                mPresenter.handleLogin(etAccount.getText().toString(), etPwd.getText().toString())
        );
    }

}
