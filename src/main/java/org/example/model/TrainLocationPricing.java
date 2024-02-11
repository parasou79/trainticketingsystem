package org.example.model;

public class TrainLocationPricing {
	private int tid;
	private int flid;
	private int tlid;
	private int price; // TODO: to be BigDecimal

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public TrainLocationPricing() {
	}

	public TrainLocationPricing(int tid, int flid, int tlid, int price) {
		this.tid = tid;
		this.flid = flid;
		this.tlid = tlid;
		this.price = price;
	}
}
