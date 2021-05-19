package com.autentia.training.springboot.statistics.airlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.training.springboot.statistics.airlines.model.dto.response.AirlineFlightsNumber;
import com.autentia.training.springboot.statistics.airlines.repository.StatisticsAirlinesRepository;

@Service
public class StatisticsAirlinesService {

	@Autowired
	private StatisticsAirlinesRepository statisticsRepository;

	public List<AirlineFlightsNumber> getFlightsByYear(int year) {
		return statisticsRepository.getFlightsByYear(year);
	}

}
