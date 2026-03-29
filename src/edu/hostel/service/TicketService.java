package edu.hostel.service;

import edu.hostel.domain.*;
import edu.hostel.exception.TicketNotFoundException;
import edu.hostel.io.DatabaseIO;

import java.util.PriorityQueue;
import java.util.ArrayList;

public class TicketService {
    private PriorityQueue<Ticket> ticketQueue;
    private DatabaseIO db;

    public TicketService() {
        this.db = new DatabaseIO();
        this.ticketQueue = new PriorityQueue<>(db.loadAll());
    }

    public void fileNewTicket(Ticket ticket) {
        ticketQueue.add(ticket);
    }

    public void resolveTicket(String ticketId) {
        boolean found = false;
        for (Ticket t : ticketQueue) {
            if (t.getTicketId().equals(ticketId) && !t.isResolved()) {
                t.markResolved();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new TicketNotFoundException("Active ticket #" + ticketId + " not found.");
        }
    }

    public void displayPendingTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
            return;
        }
        // Use a temporary queue so we don't delete the actual data while printing
        PriorityQueue<Ticket> tempQueue = new PriorityQueue<>(ticketQueue);
        while (!tempQueue.isEmpty()) {
            Ticket t = tempQueue.poll();
            if (!t.isResolved()) {
                System.out.printf("[%s] ID: %s | Room: %s%n", 
                    t.getPriority(), t.getTicketId(), t.getStudent().getRoomNumber());
            }
        }
    }

    public void saveSystemState() {
        db.saveAll(new ArrayList<>(ticketQueue));
    }
}