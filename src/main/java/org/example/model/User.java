package org.example.model;

import java.util.concurrent.ThreadLocalRandom;

public class User {
	private int uid;
	private String fname;
	private String lname;
	private String email;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
	}

	public User(String fname, String lname, String email) {
		this.uid = ThreadLocalRandom.current().nextInt(200)+301;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
}