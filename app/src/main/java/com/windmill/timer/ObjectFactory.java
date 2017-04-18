package com.windmill.timer;

import android.content.Context;
import android.view.LayoutInflater;
import com.windmill.timer.model.Timer;
import com.windmill.timer.presenters.Presenter;
import com.windmill.timer.presenters.PresenterFactory;
import com.windmill.timer.presenters.RecyclerViewAdapter;
import com.windmill.timer.presenters.TimerPresenter;

public class ObjectFactory {
    private LayoutInflater inflater;
    private Context context;

    public ObjectFactory(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.context = context;
    }


    public RecyclerViewAdapter newRecyclerViewAdapter() {
        PresenterFactory factory = new PresenterFactory() {
            @Override
            public Presenter newPresenter(Class clazz) {
                if (clazz.equals(Timer.class))
                    return new TimerPresenter(inflater.inflate(R.layout.timer, null));
                else
                    return null;
            }
        };

        return new RecyclerViewAdapter(factory);
    }

    public Context getContext() {
        return context;
    }
}
