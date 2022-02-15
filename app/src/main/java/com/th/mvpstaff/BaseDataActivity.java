package com.th.mvpstaff;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.th.mvpstaff.bean.Account;

/**
 * View的实现。Android中一般为一个Activity、Fragment或一个android.view.View
 */
public class BaseDataActivity extends AppCompatActivity implements IView {
    protected TextView tvAccount;
    protected EditText etPwd;
    protected EditText etAccount;
    protected View btLogin;
    protected View cpLogin;
    protected TextView tvLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_data);
        tvAccount = findViewById(R.id.tvAccountInfo);
        etAccount = findViewById(R.id.etAccount);
        etPwd = findViewById(R.id.etPwd);
        btLogin = findViewById(R.id.btLogin);
        cpLogin = findViewById(R.id.cpLogin);
        tvLogin = findViewById(R.id.tvLogin);
    }

    @Override
    public void updateAccountUI(Account account) {
        Util.post(() -> tvAccount.setText(account.username + ": " + account.pwd));
    }

    @Override
    public void showLogging() {
        Util.post(() -> {
            cpLogin.setVisibility(View.VISIBLE);
            tvLogin.setText("登陆中。。。");
        });
    }

    @Override
    public void hideLogging() {
        Util.post(() -> {
            cpLogin.setVisibility(View.VISIBLE);
            tvLogin.setText("登陆");
        });
    }
}
