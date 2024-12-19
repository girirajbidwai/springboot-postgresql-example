package com.spring_postgresql.demo.Controller;

import com.spring_postgresql.demo.Dao.TicketDao;
import com.spring_postgresql.demo.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketDao ticketRepository;

    // Get all tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Create a new ticket
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Get a single ticket by ID
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    // Update an existing ticket
    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setAmount(ticketDetails.getAmount());
        ticket.setCategory(ticketDetails.getCategory());

        return ticketRepository.save(ticket);
    }

    // Delete a ticket
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticketRepository.delete(ticket);
    }
}