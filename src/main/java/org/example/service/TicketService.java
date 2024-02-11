package org.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.example.model.Location;
import org.example.model.Section;
import org.example.model.Ticket;
import org.example.model.Train;
import org.example.model.User;
import org.example.utils.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

	@Autowired
	TrainService trainService;

	@Autowired
	UserService userService;

	@Autowired
	LocationService locationService;

	private static Map<Integer, Ticket> tickets = new HashMap<>();

	public Section getSection(int tid, int sid) {
		return trainService.getSection(tid, sid);
	}

	public Train getTrain(int tid) {
		return trainService.getTrain(tid);
	}

	/*
	Assumtions:
	1. ticket is created only for today
	2. train runs once per day but everyday
	 */
	public Ticket create(int tid, int sid, int uid, int flid, int tlid, int amt) {
		Section s = getSection(tid, sid);

		// if section not available or section seats are full
		if (s == null || s.getSize() == s.getSeats().size()) {
			return null;
		}

		int sno = s.allotSeat();
		Ticket tk = new Ticket(tid, sid, uid, flid, tlid, sno, amt);
		s.confirmSeat(sno, tk);
		tickets.put(tk.getRid(), tk);
		return tk;
	}

	public Ticket fetchTicket(int rid) {
		return tickets.get(rid);
	}

	public Map<String, Object> fetch(int rid) {
		Ticket tk = fetchTicket(rid);
		User user = userService.findById(tk.getUid());
		Train train = getTrain(tk.getTid());
		Section section = train.getSections().get(tk.getSid());
		Location from = locationService.findById(tk.getFlid());
		Location to = locationService.findById(tk.getTlid());
		Map<String, Object> data = new HashMap<>();
		data.put("ticket_id", tk.getRid());
		data.put("ticket_dt", tk.getDt());
		data.put("amount", tk.getAmt());
		data.put("seat", tk.getSno());
		data.put("train_id", tk.getTid());
		data.put("train_name", train.getTname());
		data.put("section_id", section.getSid());
		data.put("section_name", section.getSname());
		data.put("from", from.getLname());
		data.put("to", to.getLname());
		data.put("user_id", user.getUid());
		data.put("user_fname", user.getFname());
		data.put("user_lname", user.getLname());
		data.put("user_email", user.getEmail());
		return data;
	}

	public Collection<Ticket> fetchAll() {
		return tickets.values();
	}

	public Collection<Ticket> fetchTickets(int tid, int sid) {
		return getSection(tid, sid).getSeats().values();
	}

	public Ticket cancel(int rid) {
		Ticket tk1 = tickets.remove(rid);
		Ticket tk2 = getSection(tk1.getTid(), tk1.getSid()).cancelSeat(tk1.getSno());
		return tk1==tk2 ? tk1 : tk2; // not necessary check
	}

	/**
	 * This method is just for testing over browser/curl
	 * This could have been in junit to unit testing
	 * @return
	 */
	public Ticket createAnonymous() {
		Map<Integer, Train> trains = trainService.getTrains();
		List<Integer> trainIds = new ArrayList<>(trains.keySet());
		int tid = trainIds.get(ThreadLocalRandom.current().nextInt(trainIds.size()));

		List<Integer> sectionIds = new ArrayList<>(trains.get(tid).getSections().keySet());
		int sid = sectionIds.get(ThreadLocalRandom.current().nextInt(sectionIds.size()));

		List<User> users = userService.find(null);
		int uid = users.get(ThreadLocalRandom.current().nextInt(users.size())).getUid();

		List<Integer> locationIds = new ArrayList<>(locationService.findAll().keySet());
		int locationsCount = locationIds.size();
		int flid = locationIds.get(ThreadLocalRandom.current().nextInt(locationsCount));
		int tlid = locationIds.get(ThreadLocalRandom.current().nextInt(locationsCount));
		while (flid == tlid) {
			tlid = ThreadLocalRandom.current().nextInt(locationsCount);
		}

		int amt = ThreadLocalRandom.current().nextInt(2000)+1;

		Ticket tk = create(tid, sid, uid, flid, tlid, amt);
		return tk;
	}
}
