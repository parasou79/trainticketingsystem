package org.example.service;

import java.util.List;

import org.example.model.Location;
import org.example.model.TrainLocation;
import org.example.utils.Data;
import org.springframework.stereotype.Service;

@Service
public class TrainLocationService {
	private static List<TrainLocation> trainLocations = Data.createTrainLocations();
}
