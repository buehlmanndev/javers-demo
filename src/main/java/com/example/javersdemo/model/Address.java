package com.example.javersdemo.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String address;
    private Integer zipCode;

    public Address() {
    }

    public Address(String someStreet, int zip) {
        this.address = someStreet;
        this.zipCode = zip;
    }
}