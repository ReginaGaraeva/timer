package com.windmill.timer.presenters;

public interface PresenterFactory {
    Presenter newPresenter(Class clazz);
}
