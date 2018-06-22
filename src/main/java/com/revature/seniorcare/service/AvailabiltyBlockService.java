package com.revature.seniorcare.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.revature.seniorcare.beans.AvailabilityBlock;

public interface AvailabiltyBlockService {
	
	List<AvailabilityBlock> getAll();
	AvailabilityBlock findById(int id);
	
	List<AvailabilityBlock> getAllForWeek(Calendar cal);
	
	List<AvailabilityBlock> findAll(Sort sort);
	List<AvailabilityBlock> findAll(Iterable<Integer> ids);
	List<AvailabilityBlock> save(List<AvailabilityBlock> entities);
	void flush();
	List<AvailabilityBlock> saveAndFlush(List<AvailabilityBlock> entity);
	void deleteInBatch(Iterable<AvailabilityBlock> entities);
	void deleteAllInBatch();
	AvailabilityBlock getOne(Integer id);
	Page<AvailabilityBlock> findAll(Pageable pageable);
	Optional<AvailabilityBlock> save(Optional<AvailabilityBlock> entity);
	

}
