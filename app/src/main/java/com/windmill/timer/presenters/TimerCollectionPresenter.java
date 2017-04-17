package com.windmill.timer.presenters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.windmill.timer.model.Timer;

import java.util.ArrayList;
import java.util.List;

public class TimerCollectionPresenter {
    private RecyclerView timers;

    public class PresenterViewHolder extends RecyclerView.ViewHolder {
        private Presenter presenter;

        public PresenterViewHolder(Presenter presenter) {
            super(presenter.getView());
            this.presenter = presenter;
        }

        public Presenter getPresenter() {
            return presenter;
        }
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter {
        private PresenterFactory factory;
        private List objects = new ArrayList<>();
        private List<Class> types = new ArrayList<>();

        public RecyclerViewAdapter(PresenterFactory factory) {
            this.factory = factory;
        }

        public void set(List objects) {
            this.objects.clear();

            for (Object object : objects) {
                if (!types.contains(object.getClass()))
                    types.add(object.getClass());
            }

            this.objects.addAll(objects);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new PresenterViewHolder(factory.newPresenter(types.get(viewType)));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((PresenterViewHolder) holder).getPresenter().set(objects.get(position));
        }

        @Override
        public int getItemCount() {
            return objects.size();
        }
    }

    public TimerCollectionPresenter(RecyclerView timers) {
        this.timers = timers;

        PresenterFactory factory = new PresenterFactory() {
            @Override
            public Presenter newPresenter(Class clazz) {
                if (clazz.equals(Timer.class))
                    return new TimerPresenter();
                else
                    return null;
            }
        };

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(factory);
        timers.setAdapter(adapter);
    }
}
