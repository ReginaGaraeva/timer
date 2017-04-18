package com.windmill.timer.presenters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.windmill.timer.ObjectFactory;
import com.windmill.timer.model.Timer;

import java.util.Arrays;
import java.util.Date;

public class TimerCollectionPresenter {
    private RecyclerView timers;

    public TimerCollectionPresenter(RecyclerView timers, ObjectFactory factory) {
        this.timers = timers;

        RecyclerViewAdapter adapter = factory.newRecyclerViewAdapter();
        timers.setLayoutManager(new LinearLayoutManager(factory.getContext()));
        timers.setAdapter(adapter);
        adapter.set(Arrays.asList(new Timer(new Date()), new Timer(new Date()), new Timer(new Date()), new Timer(new Date())));
    }
}
