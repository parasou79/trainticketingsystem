package org.example.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.example.model.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class TicketServiceTest {


	@Autowired
	TicketService ticketService;

	@Test
	void fetch() {
		/* create() is programmatically tested */
		Ticket tk = ticketService.createAnonymous();
		Map<String, Object> output = ticketService.fetch(tk.getRid());
		assertEquals(output.get("ticket_id"), tk.getRid());
	}


	@Test
	void cancel() {
		Ticket tk = ticketService.createAnonymous();
		ticketService.cancel(tk.getRid());
		Collection<Ticket> tickets = ticketService.fetchAll();
		assertEquals(0, tickets.size());
	}
}