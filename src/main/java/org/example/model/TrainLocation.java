package org.example.model;

public class TrainLocation {
	private int tid;
	private int lid;
	private int seq;
	private int mins;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getMins() {
		return mins;
	}

	public void setMins(int mins) {
		this.mins = mins;
	}

	public TrainLocation() {
	}

	public TrainLocation(int tid, int lid, int seq, int mins) {
		this.tid = tid;
		this.lid = lid;
		this.seq = seq;
		this.mins = mins;
	}
}
