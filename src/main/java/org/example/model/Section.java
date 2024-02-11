package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Section {
	private int sid;
	private String sname;
	private int size;

	private List<Integer> unalloted;
	private Map<Integer, Ticket> seats = new HashMap<>(); // to track allotted seats

	public Section() {
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Section(int sid, String sname, int size) {
		this.sid = sid;
		this.sname = sname;
		this.size = size;
		this.unalloted = new ArrayList<>(size);
		for(int i=0;i<size;i++){
			this.unalloted.add(i); // un-allotted seat numbers
		}
	}

	public Map<Integer, Ticket> getSeats() {
		return seats;
	}

	public int allotSeat() {
		int idx=ThreadLocalRandom.current().nextInt(this.unalloted.size());
//		int idx=new Random().nextInt(this.unalloted.size());
		Integer sno = this.unalloted.get(idx);
		this.unalloted.remove(sno);
		return sno;
	}

	public void confirmSeat(int sno, Ticket tk) {
		this.getSeats().put(sno, tk);
	}

	public Ticket cancelSeat(int sno) {
		this.unalloted.add(sno);
		return this.getSeats().remove(sno);
	}
}
