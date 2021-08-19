package com.example.api;

import java.time.Instant;
import java.util.*;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BookSlot;
import com.example.service.SlotService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/booked-slots")
public class BookedSlotController {
	
	@Autowired
	SlotService slotService;
	
	@GetMapping(value="/{name}",produces = {"application/json"})
	public List<BookSlot> bookedSlotsByName(@PathVariable("name") String name){
		List<BookSlot> bookedList = slotService.viewBookedByName(name);
		return bookedList;
	}
	
	@GetMapping(value="/{game}/{date}",produces= {"application/json"})
	public List<BookSlot> bookedSlotsByGame(@PathVariable("game") String game, @PathVariable("date") String date){
		List<BookSlot> bookedList = slotService.viewBookedByGame(game, date);
		return bookedList;
	}
}
