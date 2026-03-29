package edu.hostel.cli;

import edu.hostel.domain.*;
import edu.hostel.service.TicketService;
import edu.hostel.exception.TicketNotFoundException;

import java.util.Scanner;
import java.util.UUID;

public class HostelApp {
    private static TicketService service = new TicketService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Enterprise Hostel Management System ===");
        boolean running = true;

        while (running) {
            System.out.println("\n1. File Complaint | 2. View Pending | 3. Resolve Ticket | 4. Exit");
            System.out.print("Select: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": handleNewTicket(); break;
                case "2": service.displayPendingTickets(); break;
                case "3": handleResolve(); break;
                case "4": 
                    service.saveSystemState();
                    running = false;
                    System.out.println("Data saved. Exiting system.");
                    break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void handleNewTicket() {
        System.out.print("Student Name: "); String name = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        System.out.print("Room Number: "); String room = scanner.nextLine();
        
        System.out.print("Category (PLUMBING, ELECTRICAL, WIFI, CARPENTRY, AC, OTHER): ");
        String catInput = scanner.nextLine().toUpperCase();
        IssueCategory cat = IssueCategory.OTHER;
        try { cat = IssueCategory.valueOf(catInput); } catch(Exception e) {}
        
        System.out.print("Priority (URGENT, HIGH, NORMAL, LOW): ");
        String priInput = scanner.nextLine().toUpperCase();
        Priority pri = Priority.NORMAL;
        try { pri = Priority.valueOf(priInput); } catch(Exception e) {}
        
        System.out.print("Description: "); String desc = scanner.nextLine();

        Student student = new Student(name, phone, room);
        // Generates a random, professional-looking 6-character ID
        String shortId = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        Ticket newTicket = new Ticket(shortId, student, cat, desc, pri);
        
        service.fileNewTicket(newTicket);
        System.out.println("✅ Ticket filed successfully! ID: " + shortId);
    }

    private static void handleResolve() {
        System.out.print("Enter Ticket ID to resolve: ");
        String id = scanner.nextLine();
        try {
            service.resolveTicket(id);
            System.out.println("✅ Ticket resolved.");
        } catch (TicketNotFoundException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}