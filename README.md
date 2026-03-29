# Hostel-Maintenance-System

# Enterprise Hostel Maintenance System (EHMS)

A comprehensive Java SE console application for managing campus hostel infrastructure and student complaints, demonstrating advanced Java concepts including OOP principles, algorithmic sorting, modern I/O operations, and domain-driven design.

## Table of Contents
* [Project Overview](#project-overview)
* [Java Evolution & Architecture](#java-evolution--architecture)
* [Installation & Setup](#installation--setup)
* [Running the Application](#running-the-application)
* [Project Structure](#project-structure)
* [Technical Implementation](#technical-implementation)
* [Advanced Concepts Implementation](#advanced-concepts-implementation)
* [Features](#features)
* [Usage Examples](#usage-examples)
* [Testing Scenarios](#testing-scenarios)

## Project Overview

EHMS is an enterprise-grade, menu-driven console application that provides comprehensive management of:
* **Complaint Ticketing:** Automated ID generation, category sorting, and timestamping.
* **Automated Triage:** Priority-based sorting (Urgent, High, Normal, Low) overriding standard FIFO queues.
* **Student Management:** Association of maintenance tickets with specific student profiles and room numbers.
* **Persistent Storage:** Data serialization to CSV formats ensuring zero data loss between sessions.
* **State Management:** Tracking ticket lifecycles from `PENDING` to `RESOLVED`.

### Key Features
* Object-oriented design with strict inheritance hierarchies and encapsulation.
* Advanced exception handling using bespoke runtime exceptions.
* Automated algorithmic sorting using Java Collections (`PriorityQueue` and `Comparable`).
* Persistent File I/O using `BufferedReader` and `BufferedWriter`.
* Domain-Driven Design (DDD) separating CLI, Services, IO, and Domain models.
* Comprehensive data validation using Enums.

---

## Java Evolution & Architecture

### Major Java Releases Timeline
* **1995: Java 1.0** - Initial release with basic OOP features.
* **1998: Java 1.2 (J2SE)** - Collections Framework introduced (crucial for this project's Queue system).
* **2004: Java 5** - Generics (used heavily in our Lists and Queues), Enums, enhanced for-loop.
* **2011: Java 7** - try-with-resources (used for safe File I/O in this project).
* **2014: Java 8** - Lambda expressions, Stream API, new Date/Time API (`java.time` used for ticket timestamps).

### Java Architecture (JDK, JRE, JVM)
* **JVM (Java Virtual Machine):** Executes the compiled `.class` bytecode of the EHMS application, ensuring platform independence across Windows/Mac/Linux.
* **JRE (Java Runtime Environment):** Provides the standard libraries (like `java.util` and `java.io`) required to run the EHMS.
* **JDK (Java Development Kit):** Used during the development phase to compile the `javac` source code into bytecode.

---

## Installation & Setup

### Prerequisites
* **Operating System:** Windows 10/11, macOS, or Linux
* **Java:** JDK 8 or higher (JDK 17+ recommended)
* **IDE:** VS Code, IntelliJ IDEA, or Eclipse

### Setup via Terminal
1. Clone the repository:
   ```bash
   git clone <repository_url>
   cd Hostel-Maintenance-System

### Running the Application
* cd src
* javac edu/hostel/cli/HostelApp.java
* java edu.hostel.cli.HostelApp

  ### Project Structure
```text
Hostel-Maintenance-System/
├── src/
│   └── edu/
│       └── hostel/
│           ├── cli/                  # Command Line Interface
│           │   └── HostelApp.java
│           ├── domain/               # Domain Models
│           │   ├── Person.java       # Abstract base class
│           │   ├── Student.java      # Inherits Person
│           │   ├── Ticket.java       # Core entity (Implements Comparable)
│           │   ├── IssueCategory.java# Enumeration
│           │   └── Priority.java     # Enumeration
│           ├── exception/            # Custom Exceptions
│           │   ├── InvalidRoomException.java
│           │   └── TicketNotFoundException.java
│           ├── service/              # Business Logic
│           │   └── TicketService.java
│           └── io/                   # I/O Operations
│               └── DatabaseIO.java   # Persistent CSV storage
├── tickets_db.csv                    # Automatically generated database
└── README.md
```

## Technical Implementation

### Technical Requirements Coverage

| Syllabus Topic | Implementation Location | Description |
| :--- | :--- | :--- |
| **Platform & Setup** | | |
| Evolution of Java | README.md | Timeline of major Java releases documented |
| Java ME vs SE vs EE | README.md | Architecture explanations and platform targeting |
| JDK/JRE/JVM | README.md | Architecture diagram and component explanations |
| Installation Steps | README.md | Environment setup instructions |
| **Language Fundamentals** | | |
| Syntax & Structure | `HostelApp.java` | Main class with clear package structure |
| Packages | All source files | `edu.hostel.*` package hierarchy |
| Variables & Operators | Multiple classes | Primitive and object variables utilized |
| Decision Structures | `HostelApp.java` | `switch` statements for CLI routing |
| Loops | `TicketService.java` | `for-each` and `while` loops for queue traversal |
| Arrays & Strings | Multiple classes | `String.split()` parsing and array manipulation |
| **Object-Oriented Programming** | | |
| Encapsulation | All domain classes | Private fields with strict getters/setters |
| Inheritance | `Person` → `Student` | Abstract base class inheritance |
| Abstraction | `Person.java` | Abstract classes preventing raw instantiation |
| Polymorphism | `TicketService.java` | Interface implementation handling |
| Access Modifiers | All classes | `private`, `protected`, and `public` routing |
| Constructor Types | `Student.java`, `Ticket.java` | Parameterized constructors and super() calls |
| Immutability | `IssueCategory.java` | Final fields within enumerations |
| **Advanced Concepts** | | |
| Interfaces | `Ticket.java` | Implements `Comparable<Ticket>` |
| Functional Interfaces | `TicketService.java` | PriorityQueue comparator logic |
| Enums | `Priority`, `IssueCategory` | Type-safe enumerations with assigned levels |
| Upcasting/Downcasting | `TicketService.java` | Object casting within Java Collections |
| Method Overriding | `Ticket.java` | Overriding `compareTo()` for triage logic |
| Design Patterns | `DatabaseIO.java` | Separation of Concerns (SoC) / DAO Pattern |
| **Exception Handling** | | |
| Exception Types | `HostelApp.java` | Checked vs Unchecked exception management |
| Custom Exceptions | `TicketNotFoundException.java` | Custom runtime exceptions extending `RuntimeException` |
| Try-Catch-Finally | `DatabaseIO.java` | Try-with-resources for safe file stream closures |
| Multi-catch | `HostelApp.java` | Handling multiple CLI input mismatch scenarios |
| **File I/O & Data Persistence** | | |
| Path & Files API | `DatabaseIO.java` | Modern file existence checks and pathing |
| Streams | `DatabaseIO.java` | `BufferedReader` / `BufferedWriter` streaming |
| Delimiter Parsing | `DatabaseIO.java` | CSV data serialization and deserialization |
| **Date/Time API** | | |
| LocalDate/DateTime | `Ticket.java` | `LocalDateTime.now()` for issue tracking |
| Formatting | `Ticket.java` | `DateTimeFormatter` pattern generation |
| **Data Structures** | | |
| Collections Framework | `TicketService.java` | Utilizing `ArrayList` and `PriorityQueue` |
| Algorithmic Sorting | `TicketService.java` | Automated triage overriding FIFO principles |

## Advanced Concepts Implementation

### 1. Algorithmic Queue Sorting
```java
// Implements Comparable interface to force PriorityQueue sorting rules
@Override
public int compareTo(Ticket other) {
    // Urgent priority (1) comes before Normal priority (3)
    return Integer.compare(this.priority.getLevel(), other.priority.getLevel());
}
```

### 2. Persistent I/O with Try-With-Resources
```java
public void saveAll(List<Ticket> tickets) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
        for (Ticket t : tickets) {
            bw.write(t.toCsvRecord());
            bw.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error saving to database: " + e.getMessage());
    }
}
```

### 3. Business Logic Validation
```java
public void resolveTicket(String ticketId) {
    boolean found = false;
    for (Ticket t : ticketQueue) {
        if (t.getTicketId().equals(ticketId)) {
            t.markResolved();
            found = true; break;
        }
    }
    if (!found) {
        throw new TicketNotFoundException("Active ticket #" + ticketId + " not found.");
    }
}
```

## Features

### Core Functionality
- [x] Create standardized maintenance tickets
- [x] Abstract User/Student profiles attached to tickets
- [x] Automated prioritization of urgent issues
- [x] Mark tickets as resolved to clear queues

### Architecture & Stability
- [x] Persistent `.csv` database generation
- [x] Auto-loading previous state on application boot
- [x] Custom error handling to prevent CLI crashes
- [x] Strict enum-based data validation

---

## Usage Examples

### Sample Application Flow

**1. Initial Setup & Loading**
```text
=== Enterprise Hostel Management System ===
Loading existing tickets from tickets_db.csv...
System ready.

1. File Complaint | 2. View Pending | 3. Resolve Ticket | 4. Exit
Select: 1
Student Name: Om
Phone: 555-0199
Room Number: Block B - 104
Category (PLUMBING, ELECTRICAL, WIFI, CARPENTRY, AC, OTHER): ELECTRICAL
Priority (URGENT, HIGH, NORMAL, LOW): URGENT
Description: Live wire exposed near the study desk.
✅ Ticket filed successfully! ID: 8F2A1C

Select: 2
[URGENT] ID: 8F2A1C | Room: Block B - 104
[NORMAL] ID: 3D9B44 | Room: Block A - 201
[LOW] ID: 77CA11 | Room: Block C - 404

Select: 3
Enter Ticket ID to resolve: 8F2A1C
✅ Ticket resolved.

Select: 4
Saving database to tickets_db.csv...
Data saved. Exiting system.
```

