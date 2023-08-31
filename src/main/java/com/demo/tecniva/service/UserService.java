package com.demo.tecniva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.tecniva.entity.User;
import com.demo.tecniva.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
		
	public List<User> getUsers() {
		List<User> data = null;
		
		data = this.repository.findAll();
		
		return data;
	}
	
	public User getUser(Long userId) {
		User data = null;
		
		data = this.repository.getReferenceById(userId);
		
		return data;
	}
	
	public boolean saveUser(User newUser) {
		boolean flag = true;
		
		try {
			newUser = this.repository.save(newUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}
	
	public boolean updateUser(Long userId, User userUpdate) {
		boolean flag = true;
		
		try {
			if(this.repository.existsById(userId)) {
				userUpdate = this.repository.save(userUpdate);
			} else {
				System.out.println("User " + userId + " not exist.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}
	
	public boolean deleteUser(Long userId) {
		boolean flag = true;
		
		try {
			if(this.repository.existsById(userId)) {
				this.repository.deleteById(userId);
			} else {
				System.out.println("User " + userId + " not exist.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}
}
