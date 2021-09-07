package com.mhp.coding.challenges.dependency.inquiry;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class InquiryEvent {

    private final ApplicationEventPublisher publisher;

    InquiryEvent(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    void publishEvent(InquiryNotificationType type, Inquiry inquiry)
    {
        //Send new notification to event publisher
        publisher.publishEvent(new InquiryNotification(type,inquiry));
    }


}
