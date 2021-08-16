package com.example.service;



import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.exception.EmailPresence;
import com.example.model.UserAccount;
import com.example.repository.UserRepository;

@Service
@Transactional
public class UserService {

	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean saveUser(UserAccount userAccount) throws EmailPresence {
		UserAccount present = userRepository.findByEmail(userAccount.getEmail());
		if(present == null) {
			userRepository.save(userAccount);
			return true;
		}
		throw new EmailPresence("email already exists");
	}
	
	public boolean checkUser(String email, String password) throws EmailPresence {
		UserAccount account = userRepository.findByEmail(email);
		if(account == null) {
			throw new EmailPresence("Sorry, account not found");
		}
		if(account.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
}
