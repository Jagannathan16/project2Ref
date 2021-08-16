package com.example.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.BookSlot;
import com.example.repository.SlotRepository;

@Service
public class SlotService {
	
	@Autowired
	SlotRepository slotRepo;
	
	public boolean saveSlot(BookSlot bookSlot) {
		
		slotRepo.save(bookSlot);
		return true;
	}
	
	public List<BookSlot> viewBooked(String userName) {
		List<BookSlot> bookedList =  slotRepo.findByName(userName);
		return bookedList;
	}
}
