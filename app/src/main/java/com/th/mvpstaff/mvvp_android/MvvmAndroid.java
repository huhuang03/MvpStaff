package com.th.mvpstaff.mvvp_android;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * BusinessLogic and Data
 */
class Model extends LiveData<Integer> {
    public Model() {
        super(0);
    }

    public void increment() {
        setValue(getValue() + 1);
    }

    public void decrement() {
        setValue(getValue() + 1);
    }
}

//  view model is this.
class CountViewModel extends ViewModel {
    // model is the MutableLiveData
    private Model count = new Model();

    public Model getCount() {
        return count;
    }
}