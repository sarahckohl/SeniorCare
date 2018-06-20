package com.revature.seniorcare.service;

import java.util.List;

import com.revature.seniorcare.beans.Note;

public interface NoteService {
	
	List<Note> getAll();
	Note findById(int id);

}
