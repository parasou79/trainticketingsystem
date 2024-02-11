package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Train {
	private int tid;
	private String tname;
	private Map<Integer, Section> sections = new HashMap<>();
//	private List<TrainLocation> trainLocations = new ArrayList<>();
//	private List<TrainLocationPricing> trainLocationPricings = new ArrayList<>();

	public Train() {
	}

	public Train(int tid, String tname) {
		this.tid = tid;
		this.tname = tname;
		Section s1 = new Section(1,"A",30);
		Section s2 = new Section(2,"B",40);
		this.sections = Map.of(1, s1, 2, s2);
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<Integer, Section> getSections() {
		return sections;
	}

	public void setSections(Map<Integer, Section> sections) {
		this.sections = sections;
	}
}
