package org.example.service;

import java.util.List;
import java.util.Map;

import org.example.model.Location;
import org.example.utils.Data;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	private static Map<Integer, Location> locations = Data.createLocations();

	public Map<Integer, Location> findAll() {
		return locations; // keep unmodifiable
	}

	public List<Location> findFiltered(Location location) {
		throw new UnsupportedOperationException();
	}

	public Location findById(int lid) {
		return locations.get(lid);
	}
}
