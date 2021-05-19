package com.autentia.training.springboot.statistics.airlines.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.autentia.training.springboot.statistics.airlines.model.dto.response.AirlineFlightsNumber;

@Repository
public class StatisticsAirlinesRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<AirlineFlightsNumber> getFlightsByYear(int year) {

		String sql = " select Carrier, sum(AirlineID) as flights from ontime where Year = ? group by Carrier order by flights desc";
		return jdbcTemplate.query(
				sql,
				new Object[] { year },
				(rs, rowNum) -> {
					return new AirlineFlightsNumber(rs.getString("Carrier"), rs.getLong("flights"));
				});
	}

}
