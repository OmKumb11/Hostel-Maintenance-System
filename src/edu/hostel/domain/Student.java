package edu.hostel.domain;

public class Student extends Person {
    private String roomNumber;

    public Student(String name, String contactNumber, String roomNumber) {
        super(name, contactNumber);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() { return roomNumber; }
}