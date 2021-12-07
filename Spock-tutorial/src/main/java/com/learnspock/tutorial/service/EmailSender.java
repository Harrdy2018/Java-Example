package com.learnspock.tutorial.service;

import com.learnspock.tutorial.Customer;

public interface EmailSender {
    void sendEmail(Customer c);
}
