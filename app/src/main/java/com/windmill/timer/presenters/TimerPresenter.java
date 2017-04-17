package com.windmill.timer.presenters;

import android.view.View;
import com.windmill.timer.model.Timer;

public class TimerPresenter implements Presenter<Timer> {
    private View view;
    private Timer timer;

    public TimerPresenter(View view) {
        this.view = view;
    }

    @Override
    public void set(Timer timer) {
        this.timer = timer;
    }

    @Override
    public View getView() {
        return view;
    }
}
