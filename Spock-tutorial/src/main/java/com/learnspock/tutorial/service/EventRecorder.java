package com.learnspock.tutorial.service;

public interface EventRecorder {
    void recordEvent(Event e);
}

class Event{
    public Event(Type type, Long timestamp, String customerName) {
        this.type = type;
        this.timestamp = timestamp;
        this.customerName = customerName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    enum Type{SENT, NOT_SENT}

    private Type type;

    private Long timestamp;

    private String customerName;
}