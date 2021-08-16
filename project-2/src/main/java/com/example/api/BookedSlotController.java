package com.example.api;

import java.util.*;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BookSlot;
import com.example.service.SlotService;

@RestController
@RequestMapping("/booked-slots")
public class BookedSlotController {
	
	@Autowired
	SlotService slotService;
	
	@GetMapping(value="/{name}",produces = {"application/json"})
	public List<BookSlot> bookedSlots(@PathVariable("name") String name){
		List<BookSlot> bookedList = slotService.viewBooked(name);
		return bookedList;
	}
}
