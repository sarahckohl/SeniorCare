package com.revature.seniorcare.repository;

import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.seniorcare.beans.AvailabilityBlock;

@Transactional
public interface AvailabilityBlockRepository extends JpaRepository<AvailabilityBlock, Integer>{
	
	
	List<AvailabilityBlock> findAll();
	AvailabilityBlock findById(int AvailabilityID);
	List<AvailabilityBlock> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(Calendar endDate, Calendar startDate);
	//list of possible queries    https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
	
}