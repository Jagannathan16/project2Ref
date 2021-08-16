package com.example.api;

import lombok.Data;

@Data
public class UserRequest {
	String name;
	String email;
	String mobile;
	String password;
}
