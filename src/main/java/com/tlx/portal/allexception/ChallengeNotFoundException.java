package com.tlx.portal.allexception;

import com.tlx.portal.shared.NotificationException;

public class ChallengeNotFoundException extends NotificationException {


    public ChallengeNotFoundException(String message) {
        super(message,404);
    }


}
