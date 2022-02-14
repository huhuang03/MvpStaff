package com.th.mvpstaff.mvp;

class PresentImpl implements Contact.Present {
    private Contact.Model model = new ModelImpl();
    private Contact.View view;

    public PresentImpl(Contact.View view) {
        this.view = view;
        this.view.setText(model.getCount() + "");
    }

    @Override
    public void handleClickIncrease() {
        this.model.increaseCount();
        this.view.setText(this.model.getCount() + "");
    }

    @Override
    public void handleClickRecuse() {
        this.model.reduceCount();
        this.view.setText(this.model.getCount() + "");
    }
}

class ModelImpl implements Contact.Model {
    private int current = 0;

    @Override
    public void increaseCount() {
        current += 1;
    }

    @Override
    public void reduceCount() {
        current -= 1;
    }

    @Override
    public int getCount() {
        return current;
    }
}