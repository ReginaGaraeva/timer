package com.windmill.timer.presenters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.windmill.timer.R;
import com.windmill.timer.model.Timer;

public class TimerPresenter implements Presenter<Timer> {
    @BindView(R.id.timer_time) TextView time;
    private View view;
    private Timer timer;

    public TimerPresenter(LayoutInflater inflater) {
        this.view = inflater.inflate(R.layout.timer, null);
    }

    @Override
    public void set(Timer timer) {
        this.timer = timer;
        time.setText(timer.getTime().toString());
    }

    @Override
    public View getView() {
        return view;
    }
}
