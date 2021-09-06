package com.mhp.coding.challenges.dependency.notifications;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.InquiryNotification;
import com.mhp.coding.challenges.dependency.inquiry.InquiryNotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @Autowired
    private EmailHandler emailHandler;

    @Autowired
    private PushNotificationHandler pushNotificationHandler;

    @Async
    @EventListener
    void handleAsyncEvent(InquiryNotification notification)
    {
        //Match notification type and trigger appropriate bean
        if(InquiryNotificationType.Email.equals( notification.getType())) emailHandler.sendEmail(notification.getInquiry() );
        if(InquiryNotificationType.Push.equals( notification.getType())) pushNotificationHandler.sendNotification(notification.getInquiry() );
    }

}
