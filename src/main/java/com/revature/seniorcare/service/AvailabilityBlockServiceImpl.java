package com.revature.seniorcare.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.datetime.standard.DateTimeContext;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.beans.AvailabilityBlock;
import com.revature.seniorcare.repository.AppointmentRepository;
import com.revature.seniorcare.repository.AvailabilityBlockRepository;

@Service("AvailabilityBlockService")
@Transactional
public class AvailabilityBlockServiceImpl implements AvailabiltyBlockService{
	
	@Autowired
	private AvailabilityBlockRepository availabilityBlockRepo;

	@Override
	public List<AvailabilityBlock> getAllForWeek(Calendar dateMonday) {
		Calendar dateFriday = dateMonday;
		dateFriday.add(Calendar.DAY_OF_MONTH, 5);
		return availabilityBlockRepo.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(dateFriday, dateMonday);
	}
	
	@Override
	public List<AvailabilityBlock> findAll(Sort sort) {
		return availabilityBlockRepo.findAll();
	}

	@Override
	public List<AvailabilityBlock> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvailabilityBlock> save(List<AvailabilityBlock> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AvailabilityBlock> saveAndFlush(List<AvailabilityBlock> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<AvailabilityBlock> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AvailabilityBlock getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AvailabilityBlock> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AvailabilityBlock> save(Optional<AvailabilityBlock> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvailabilityBlock findById(int AvailabilityID) {
		return availabilityBlockRepo.findOne(AvailabilityID);
	}

	@Override
	public List<AvailabilityBlock> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
