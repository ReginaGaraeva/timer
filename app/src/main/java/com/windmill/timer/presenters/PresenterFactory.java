package com.windmill.timer.presenters;

interface PresenterFactory {
    Presenter newPresenter(Class clazz);
}
