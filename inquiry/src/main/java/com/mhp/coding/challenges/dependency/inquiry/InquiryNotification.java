package com.mhp.coding.challenges.dependency.inquiry;

public class InquiryNotification {

    InquiryNotificationType type;
    Inquiry inquiry;

    public InquiryNotification(InquiryNotificationType type, Inquiry inquiry) {
        this.type = type;
        this.inquiry = inquiry;
    }

    public InquiryNotificationType getType() {
        return this.type;
    }

    public Inquiry getInquiry() {
        return this.inquiry;
    }
}
