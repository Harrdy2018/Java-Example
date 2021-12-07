package com.learnspock.tutorial.service;

import com.learnspock.tutorial.Customer;

public class DefaultEmailService {
    private CustomerService customerService;

    private EmailSender emailSender;

    private EventRecorder eventRecorder;

    public DefaultEmailService(CustomerService customerService, EmailSender emailSender){
        this.customerService = customerService;
        this.emailSender = emailSender;
    }

    public DefaultEmailService(CustomerService customerService, EmailSender emailSender, EventRecorder eventRecorder) {
        this.customerService = customerService;
        this.emailSender = emailSender;
        this.eventRecorder = eventRecorder;
    }

    public void notifyIfNessary(Customer c){
        if (customerService.hasSubscribeEmail(c)){
            emailSender.sendEmail(c);
        }
    }
}
