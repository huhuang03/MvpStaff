package com.th.mvpstaff.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Account extends BaseObservable {
    public String username;
    public String pwd;

    public Account(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    @Bindable
    public String getPwd() {
        return pwd;
    }
}
