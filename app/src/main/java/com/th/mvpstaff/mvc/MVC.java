package com.th.mvpstaff.mvc;

/**
 * https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller
 * https://developer.mozilla.org/en-US/docs/Glossary/MVC
 *
 * Maintain the data and *update ui*
 */
interface Model {
    void increase();
    void reduce();
}

/**
 * Display UI
 */
interface View {
    void setText(String text);
}

/**
 * Routes commands to model and view parts.
 *
 * And can update ui directly somethings.
 */
interface Controller {
    void handleIncrease();
    void handleReduce();
}

class ControllerImpl implements Controller {
    private Model model;

    public ControllerImpl(View view) {
        this.model = new ModelImpl(view);
    }

    @Override
    public void handleIncrease() {
        model.increase();
    }

    @Override
    public void handleReduce() {
        model.reduce();
    }
}

class ModelImpl implements Model {
    private int current = 0;
    private View view;

    public ModelImpl(View view) {
        this.view = view;
        this.view.setText(current + "");
    }

    @Override
    public void increase() {
        current += 1;
        view.setText(current + "");
    }

    @Override
    public void reduce() {
        current -= 1;
        view.setText(current + "");
    }
}