package org.example.service;

import java.util.List;

import org.example.model.TrainLocationPricing;
import org.example.utils.Data;
import org.springframework.stereotype.Service;

@Service
public class TrainLocationPricingService {
	private static List<TrainLocationPricing> trainLocationPricingss = Data.createTrainLocationPrincings();


}
