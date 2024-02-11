package org.example.model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ticket {
	private int rid;
	private int tid;
	private int sid;
	private int uid;
	private int flid;
	private int tlid;
	private int sno;
	private int amt; // TODO: use appropriate data type
	private String dt; // DD/MM/YYYY TODO: use Date type

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getFlid() {
		return flid;
	}

	public void setFlid(int flid) {
		this.flid = flid;
	}

	public int getTlid() {
		return tlid;
	}

	public void setTlid(int tlid) {
		this.tlid = tlid;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public Ticket() {
	}

	public Ticket(int tid, int sid, int uid, int flid, int tlid, int sno, int amt) {
		this.dt ="01/01/2024"; // TODO: pick current date
		this.rid = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE)+1;
		this.tid = tid;
		this.sid = sid;
		this.uid = uid;
		this.flid = flid;
		this.tlid = tlid;
		this.sno = sno;
		this.amt = amt;
	}
}
