package com.example.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.TimeEntity;
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
	
	public List<BookSlot> viewBookedByName(String userName) {
		List<BookSlot> bookedList =  slotRepo.findByName(userName);
		return bookedList;
	}
	public List<BookSlot> viewBookedByGame(String game, String date){
		List<BookSlot> bookedList = slotRepo.findByGame(game, date);
		return bookedList;
	}
}
