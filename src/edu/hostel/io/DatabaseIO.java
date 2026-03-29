package edu.hostel.io;

import edu.hostel.domain.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseIO {
    private static final String FILE_NAME = "tickets_db.csv";

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

    public List<Ticket> loadAll() {
        List<Ticket> tickets = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return tickets;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // Rebuilds the objects from the saved text file
                if (data.length == 9) {
                    Student s = new Student(data[1], data[2], data[3]);
                    Ticket t = new Ticket(data[0], s, IssueCategory.valueOf(data[4]), data[5], Priority.valueOf(data[6]));
                    if (Boolean.parseBoolean(data[7])) t.markResolved();
                    tickets.add(t);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading database. Starting fresh.");
        }
        return tickets;
    }
}