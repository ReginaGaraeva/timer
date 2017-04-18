package com.windmill.timer.presenters;

import android.view.View;

public interface Presenter<T> {
    void set(T obj);
    View getView();
}
