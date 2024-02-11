package org.example.controller;

import java.util.Collection;
import java.util.Map;

import org.example.model.Ticket;
import org.example.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Ticket> fetchAll() {
		ticketService.createAnonymous(); // just to ease the manual testing
		Collection<Ticket> tickets = ticketService.fetchAll();
		return tickets;
	}

	@GetMapping(value="/{tid}/{sid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Ticket> fetchFiltered(@PathVariable int tid, @PathVariable int sid) {
		Collection<Ticket> tickets = ticketService.fetchTickets(tid, sid);
		return tickets;
	}

	@PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Ticket create(@RequestBody Ticket tk) {
		return ticketService.create(tk.getTid(), tk.getSid(), tk.getUid(), tk.getFlid(), tk.getTlid(), tk.getAmt());
	}

	@DeleteMapping(value="/{rid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ticket remove(@PathVariable int rid) {
		return ticketService.cancel(rid);
	}

	@GetMapping(value="/{rid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> fetch(@PathVariable int rid) {
		Map<String, Object> tickets = ticketService.fetch(rid);
		return tickets;
	}

}
