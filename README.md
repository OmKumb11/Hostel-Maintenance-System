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
 * Hostel-Maintenance-System/
*├── src/
*│   └── edu/
*│       └── hostel/
*│           ├── cli/                  # Command Line Interface
*│           │   └── HostelApp.java
*│           ├── domain/               # Domain Models
*│           │   ├── Person.java       # Abstract base class
*│           │   ├── Student.java      # Inherits Person
*│           │   ├── Ticket.java       # Core entity (Implements Comparable)
*│           │   ├── IssueCategory.java# Enumeration
*│           │   └── Priority.java     # Enumeration
*│           ├── exception/            # Custom Exceptions
*│           │   ├── InvalidRoomException.java
*│           │   └── TicketNotFoundException.java
*│           ├── service/              # Business Logic
*│           │   └── TicketService.java
*│           └── io/                   # I/O Operations
*│               └── DatabaseIO.java   # Persistent CSV storage
*├── tickets_db.csv                    # Automatically generated database
*└── README.md

