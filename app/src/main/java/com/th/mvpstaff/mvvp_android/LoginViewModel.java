package com.th.mvpstaff.mvvp_android;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.th.mvpstaff.bean.Account;

interface Model {
    void setAccount(Account account);
}

class ModelImpl implements Model {
    private void saveToDb(Account account) {
    }

    @Override
    public void setAccount(Account account) {
        saveToDb(account);
        // other data manager..
    }
}

public class LoginViewModel extends ViewModel {
    // for simply, make public here
    public MutableLiveData<Boolean> isLogin = new MutableLiveData<>(false);
    public MutableLiveData<Account> account = new MutableLiveData<>(null);
    public MutableLiveData<String> username = new MutableLiveData<>("");
    public MutableLiveData<String> pwd = new MutableLiveData<>("");
}