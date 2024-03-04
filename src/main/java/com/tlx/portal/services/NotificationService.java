package com.tlx.portal.services;


import com.tlx.portal.allexception.ChallengeNotFoundException;
import com.tlx.portal.classes.Notification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NotificationService {
    private List<Notification> notifications = new ArrayList<>();

    static Long idCounter= 0L;

    private synchronized Long getNextId() {
        return idCounter++; // Increment idCounter and return the next id
    }
    public NotificationService(){
        notifications.add(new Notification("Test Message 1", new Date(), "Message 1", false, getNextId()));
        notifications.add(new Notification("Test Message 2", new Date(), "Message 2", false, getNextId()));
        notifications.add(new Notification("Test Message 3", new Date(), "Message 3", false, getNextId()));

    }
    public List<Notification> getAllNotifications() {
        return notifications;
    }
    public Notification getNotificationById(Long id)  {
        for (Notification notification : notifications) {
            if (notification.getUserId() .equals(id)) {
                return notification;
            }
        }
        throw new ChallengeNotFoundException("The user with id "+id+" does not exist");  // Return null if notification not found
    }
    public void addNotification(Notification notification) {
        notification.setDate(new Date());
        notification.setUserId(getNextId());
        notifications.add(notification);
    }


}
