package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.EmailPresence;
import com.example.model.LoginRequest;
import com.example.model.UserAccount;
import com.example.service.UserService;

@RestController
@RequestMapping("/")
public class UserAccountController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("sign-in")
	public ResponseEntity<?> createAccount(@RequestBody UserAccount userAccount){
		System.out.println(userAccount.toString());
		String msg = "";
		boolean status = false;
		try {
			status = userService.saveUser(userAccount);
		} catch (EmailPresence e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(status + " " + msg);
	}
	
	@PostMapping("log-in")
	public ResponseEntity<?> allowUser(@RequestBody LoginRequest loginRequest){
		boolean status = false;
		String msg = "";
		try {
			status = userService.checkUser(loginRequest.getEmail(), loginRequest.getPassword());
		} catch (EmailPresence e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(status + " " + msg);
	}
}
