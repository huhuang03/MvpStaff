package com.th.mvpstaff.mvp;

public interface Contact {
    /**
     * Layer for data operator.
     * Model with View don't know each other.
     */
    interface Model {
        void increaseCount();
        void reduceCount();
        int getCount();
    }

    interface View {
        void setText(String text);
    }

    interface Present {
        void handleClickIncrease();
        void handleClickRecuse();
    }
}
