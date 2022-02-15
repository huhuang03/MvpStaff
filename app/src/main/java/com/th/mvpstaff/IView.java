package com.th.mvpstaff;

import com.th.mvpstaff.bean.Account;

/**
 * View层，只负责展示
 */
public interface IView {
    /**
     * 展示当前Account
     */
    void updateAccountUI(Account account);

    /**
     * 开始展示登陆中提醒
     */
    void showLogging();

    /**
     * 停止展示登陆中提醒
     */
    void hideLogging();
}
