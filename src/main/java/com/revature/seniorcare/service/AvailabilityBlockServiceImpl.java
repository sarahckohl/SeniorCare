package com.revature.seniorcare.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.beans.AvailabilityBlock;
import com.revature.seniorcare.repository.AppointmentRepository;
import com.revature.seniorcare.repository.AvailabilityBlockRepository;

@Service("AvailabilityBlockService")
@Transactional
public class AvailabilityBlockServiceImpl implements AvailabilityBlockRepository{
	
	@Autowired
	private AvailabilityBlockRepository availabilityBlockRepo;

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
	public <S extends AvailabilityBlock> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends AvailabilityBlock> S saveAndFlush(S entity) {
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
	public <S extends AvailabilityBlock> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvailabilityBlock findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AvailabilityBlock entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends AvailabilityBlock> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AvailabilityBlock> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvailabilityBlock findById(int AvailabilityID) {
		return availabilityBlockRepo.findOne(AvailabilityID);
	}
}
