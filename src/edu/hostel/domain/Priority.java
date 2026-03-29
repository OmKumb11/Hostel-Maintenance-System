package edu.hostel.domain;


public enum Priority {
    URGENT(1),
    HIGH(2),
    NORMAL(3),
    LOW(4);

    private final int level;

    Priority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}