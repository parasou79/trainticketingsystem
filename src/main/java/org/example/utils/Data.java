package org.example.utils;

import java.util.List;
import java.util.Map;

import org.example.model.Location;
import org.example.model.Train;
import org.example.model.TrainLocation;
import org.example.model.TrainLocationPricing;
import org.example.model.User;

public class Data {
	public static List<User> createUsers() {
		return List.of(
				new User("F1", "L1", "E1@gmail.com"),
				new User("F2", "L2", "E2@gmail.com"),
				new User("F3", "L3", "E3@gmail.com")
		);
	}

	public static Map<Integer, Train> createTrains() {
		return Map.of(101, new Train(101, "Train1"),
				102, new Train(102, "Train2"),
				103, new Train(103, "Train3")
		);
	}

	public static Map<Integer, Location> createLocations() {
		return Map.of(
				201, new Location(201, "London"),
				202, new Location(202, "Paris"),
				203, new Location(203, "Brussels"),
				204, new Location(204, "Amsterdam"),
				205, new Location(205, "Berlin"),
				206, new Location(206, "Frankfurt"),
				207, new Location(207, "Milan"),
				208, new Location(208, "Lyon"),
				209, new Location(209, "Barcelona"),
				210, new Location(210, "Madrid")
		);
	}

	public static List<TrainLocation> createTrainLocations() {
		return List.of(
				new TrainLocation(101, 201, 0, 0),
				new TrainLocation(101, 202, 1, 30),
				new TrainLocation(101, 203, 2, 60),
				new TrainLocation(101, 204, 3, 90),
				new TrainLocation(101, 205, 5, 120),

				new TrainLocation(102, 203, 0, 0),
				new TrainLocation(102, 207, 1, 20),
				new TrainLocation(102, 209, 2, 40)
		);
	}

	public static List<TrainLocationPricing> createTrainLocationPrincings() {
		return List.of(
				new TrainLocationPricing(101, 201, 202, 30),
				new TrainLocationPricing(101, 201, 203, 60),
				new TrainLocationPricing(101, 201, 204, 90),
				new TrainLocationPricing(101, 201, 205, 120),

				new TrainLocationPricing(102, 203, 207, 10),
				new TrainLocationPricing(102, 207, 209, 20),
				new TrainLocationPricing(102, 203, 209, 28)
		);
	}
}
