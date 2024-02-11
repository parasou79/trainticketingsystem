package org.example.model;

public class Location {
	private int lid;
	private String lname;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Location() {
	}

	public Location(int lid, String lname) {
		this.lid = lid;
		this.lname = lname;
	}
}
