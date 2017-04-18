package com.windmill.timer.model;

import java.util.Date;

public class Timer {
    private Date time;

    public Timer(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
