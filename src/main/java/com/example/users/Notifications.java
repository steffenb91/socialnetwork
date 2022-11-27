package com.example.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.notifications.Notification;

class Notifications {
    
    private List<Notification> unreadNotifications = new ArrayList<>();

    void readAll(){
        unreadNotifications.forEach(notification -> notification.read());
        unreadNotifications = new ArrayList<>();
    }

    void add(Notification notification) {
        unreadNotifications.add(notification);
    }

    List<Notification> getUnreadNotifications() {
        return Collections.unmodifiableList(unreadNotifications);
    }
}
