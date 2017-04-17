package com.windmill.timer.presenters;

import android.view.View;

interface Presenter<T> {
    void set(T obj);
    View getView();
}
