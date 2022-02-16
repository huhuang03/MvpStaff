package com.th.mvpstaff.mvvp_android;

import com.th.mvpstaff.Config;
import com.th.mvpstaff.Util;
import com.th.mvpstaff.bean.Account;

interface IModel {
    void login(String username, String pwd);
}

class MvvmModelImpl implements IModel {
    private LoginViewModel viewModel;

    /**
     * Model引用View，并操作view更新UI
     */
    public MvvmModelImpl(LoginViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void login(String username, String pwd) {
        if (viewModel.isLogging.getValue().get()) {
            return;
        }
        viewModel.isLogging.getValue().set(true);

        Util.postDelay(() -> {
            viewModel.isLogging.getValue().set(false);
            Account account = new Account(username, pwd);
            viewModel.account.setValue(account);
        }, Config.LOGIN_DURATION);
    }
}
