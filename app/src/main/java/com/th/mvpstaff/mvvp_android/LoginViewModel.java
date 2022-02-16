package com.th.mvpstaff.mvvp_android;


import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.th.mvpstaff.bean.Account;

public class LoginViewModel extends ViewModel {
    // for simply, make public here
    public LiveData<ObservableBoolean> isLogging = new MutableLiveData<>(new ObservableBoolean(false));
    public MutableLiveData<Account> account = new MutableLiveData<>(null);
    public MutableLiveData<String> username = new MutableLiveData<>("");
    public MutableLiveData<String> pwd = new MutableLiveData<>("");
}