package com.spring_postgresql.demo.Dao;

import com.spring_postgresql.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Long> {
}
