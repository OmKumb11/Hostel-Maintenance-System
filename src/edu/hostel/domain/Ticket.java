package edu.hostel.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket implements Comparable<Ticket>, Serializable {
    private String ticketId;
    private Student student;
    private IssueCategory category;
    private String description;
    private Priority priority;
    private boolean isResolved;
    private String timestamp;

    public Ticket(String ticketId, Student student, IssueCategory category, String description, Priority priority) {
        this.ticketId = ticketId;
        this.student = student;
        this.category = category;
        this.description = description;
        this.priority = priority;
        this.isResolved = false;
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.timestamp = now.format(formatter);
    }

    public String getTicketId() { return ticketId; }
    public boolean isResolved() { return isResolved; }
    public Priority getPriority() { return priority; }
    public Student getStudent() { return student; }
    
    public void markResolved() { this.isResolved = true; }

    @Override
    public int compareTo(Ticket other) {
        return Integer.compare(this.priority.getLevel(), other.priority.getLevel());
    }

    public String toCsvRecord() {
        return String.join(",", 
            ticketId, student.getName(), student.getContactNumber(), student.getRoomNumber(), 
            category.name(), description, priority.name(), String.valueOf(isResolved), timestamp
        );
    }
}