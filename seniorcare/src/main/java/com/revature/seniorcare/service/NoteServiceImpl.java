package com.revature.seniorcare.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.Note;
import com.revature.seniorcare.repository.NoteRepository;

@Service("PatientNoteService")
@Transactional
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	private NoteRepository NoteRepo;

	@Override
	public List<Note> getAll() {
		return NoteRepo.findAll();
	}

	@Override
	public Note findById(int id) {
		return NoteRepo.findOne(id);
	}

}
