package com.th.mvpstaff.mvc;

import com.th.mvpstaff.Config;
import com.th.mvpstaff.IView;
import com.th.mvpstaff.bean.Account;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Model里面写业务逻辑和更新UI。重Model，轻Controller
 *
 * https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller
 * https://developer.mozilla.org/en-US/docs/Glossary/MVC
 *
 * It directly manages the data, logic and rules of the application.
 */
interface Model {
    void login(String username, String pwd);
}

/**
 * Display UI
 */
interface View extends IView  {
}

/**
 * Accepts input and converts it to commands for the model or view
 *
 * And can update ui directly somethings.
 */
interface Controller {
    void handleLogin(String username, String pwd);
}

class ControllerImpl implements Controller {
    private Model model;

    public ControllerImpl(View view) {
        this.model = new ModelImpl(view);
    }

    @Override
    public void handleLogin(String username, String pwd) {
        model.login(username, pwd);
    }
}

class ModelImpl implements Model {
    private View view;
    private boolean isLogging = false;

    /**
     * Model引用View，并操作view更新UI
     */
    public ModelImpl(View view) {
        this.view = view;
    }

    @Override
    public void login(String username, String pwd) {
        if (isLogging) {
            return;
        }
        view.showLogging();
        isLogging = true;

        // do the login staff
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                view.hideLogging();
                Account account = new Account(username, pwd);
                view.updateAccountUI(account);
                isLogging = false;
            }
        }, Config.LOGIN_DURATION);
    }
}