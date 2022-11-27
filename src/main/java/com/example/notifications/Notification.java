package com.example.notifications;

import java.util.Date;

public abstract class Notification {

    protected Date creationDate;

    public Notification() {
        creationDate = new Date();
    }

    protected Date getCreationDate() {
        return creationDate;
    }

    public abstract void read();
}
