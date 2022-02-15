package com.th.mvpstaff.mvp;


import com.th.mvpstaff.Config;
import com.th.mvpstaff.IView;
import com.th.mvpstaff.bean.Account;

import java.util.Timer;
import java.util.TimerTask;

interface View extends IView {
}


interface Present {
    void handleLogin(String username, String account);
}


class PresentImpl implements Present {
    private Model model = new ModelImpl();
    private View view;
    private boolean isLogging = false;

    public PresentImpl(View view) {
        this.view = view;
    }

    @Override
    public void handleLogin(String username, String pwd) {
        if (isLogging) {
            return;
        }
        view.showLogging();
        isLogging = true;

        // do the login business
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                view.hideLogging();
                Account account = new Account(username, pwd);
                model.setAccount(account);
                view.updateAccountUI(account);
                isLogging = false;
            }
        }, Config.LOGIN_DURATION);
    }
}

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
