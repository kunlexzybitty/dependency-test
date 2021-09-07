package com.mhp.coding.challenges.dependency.inquiry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class InquiryService implements  ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(InquiryService.class);

    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public void create(final Inquiry inquiry)
    {
        LOG.info("User sent inquiry: {}", inquiry);

        //trigger email event
        this.applicationContext.getBean(InquiryEvent.class).publishEvent(InquiryNotificationType.Email,inquiry);

        //trigger push event
        this.applicationContext.getBean(InquiryEvent.class).publishEvent(InquiryNotificationType.Push,inquiry);
    }

}
