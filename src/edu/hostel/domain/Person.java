package edu.hostel.domain;

import java.io.Serializable;

public abstract class Person implements Serializable {
    protected String name;
    protected String contactNumber;

    public Person(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }
}