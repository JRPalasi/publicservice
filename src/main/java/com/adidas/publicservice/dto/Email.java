package com.adidas.publicservice.dto;

/**
 * Email DTO for email service
 */
public class Email {

    /**
     * Email "to" address for sending the email to.
     */
    private String to;

    /**
     * Name of the email receiver
     */
    private String name;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
