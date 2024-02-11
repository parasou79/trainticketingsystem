package org.example.service;

import java.util.Collection;
import java.util.Map;

import org.example.model.Section;
import org.example.model.Train;
import org.example.utils.Data;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
	private static Map<Integer, Train> trains = Data.createTrains();

	public Section getSection(int tid, int sid) {
		return trains.get(tid).getSections().get(sid);
	}

	public Map<Integer, Train> getTrains() {
		return trains; //make as unmodifable
	}

	public Train getTrain(int tid) {
		return trains.get(tid);
	}
}
