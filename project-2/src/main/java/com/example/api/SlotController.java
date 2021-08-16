package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BookSlot;
import com.example.repository.SlotRepository;
import com.example.service.SlotService;

@RestController
@RequestMapping("/book-slot")
public class SlotController {
	
	@Autowired
	public SlotService slotService;
	
	@PostMapping
	public ResponseEntity<?> book(@RequestBody BookSlot bookSlot){
		boolean bool = slotService.saveSlot(bookSlot);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookSlot);
	}
}
