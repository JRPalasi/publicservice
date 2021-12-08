package com.adidas.publicservice.dto;

import java.time.LocalDate;


public class Subscription {

    Long id;
    String name;
    String email;
    Gender gender;
    LocalDate birthDate;
    boolean consentGiven;
    Long newsletterId;

    public enum Gender {MALE, FEMALE}


    public Subscription() {
    }


    public Subscription(String name, String email, Gender gender, LocalDate birthDate, boolean consentGiven,
                        Long newsletterId) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.consentGiven = consentGiven;
        this.newsletterId = newsletterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isConsentGiven() {
        return consentGiven;
    }

    public void setConsentGiven(boolean consentGiven) {
        this.consentGiven = consentGiven;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNewsletterId() {
        return newsletterId;
    }

    public void setNewsletterId(Long newsletterId) {
        this.newsletterId = newsletterId;
    }


}
