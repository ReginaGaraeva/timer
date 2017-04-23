package com.windmill.timer.presenters;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.windmill.timer.R;
import com.windmill.timer.models.Timer;

public class TimerPresenter implements Presenter<Timer> {
    @BindView(R.id.timer_time)
    TextView time;
    private View view;
    private Timer timer;

    public TimerPresenter(View view) {
        this.view = view;

        ButterKnife.bind(this, view);
    }

    @Override
    public void set(Timer timer) {
        this.timer = timer;
        time.setText(String.format("%s:%s:%s", timer.getTime().getHours(), timer.getTime().getMinutes(), timer.getTime().getSeconds()));
    }

    @Override
    public View getView() {
        return view;
    }
}
