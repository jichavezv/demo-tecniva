package com.demo.tecniva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tecniva.dto.ResponseDTO;
import com.demo.tecniva.entity.User;
import com.demo.tecniva.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {
	@Autowired
	UserService service;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllData() {
		ResponseEntity<List<User>> response = null;
		List<User> list = null;

		list = this.service.getUsers();

		if(!list.isEmpty()) {
			response = new ResponseEntity<List<User>>(list, HttpStatus.OK);
		} else {
			response = new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}

		return response;
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> get(@PathVariable("id") long id) {
		ResponseEntity<User> response = null;
		User data = null;

		data = this.service.getUser(id);

		if (data != null) {
			response = new ResponseEntity<>(data, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@PostMapping("/users")
	public ResponseEntity<ResponseDTO<Boolean>> create(@RequestBody User userData) {
		ResponseEntity<ResponseDTO<Boolean>> response;
		ResponseDTO<Boolean> dto = null;
		Boolean result = null;
		String message = null;
		HttpStatus status = null;

		try {
			result = this.service.saveUser(userData);

			if(result) {
				message = "User saved.";
				status = HttpStatus.CREATED;
			} else {
				message = "User not saved.";
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
			message = "Can not saved the user.";
			status = HttpStatus.BAD_REQUEST;
		} finally {
			dto = new ResponseDTO<>();
			dto.setObject(result);
			dto.setMessage(message);

			response = new ResponseEntity<ResponseDTO<Boolean>>(dto, status);
		}

		return response;
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<ResponseDTO<Boolean>> update(@PathVariable("id") long id, @RequestBody User userUpdate) {
		ResponseEntity<ResponseDTO<Boolean>> response;
		ResponseDTO<Boolean> dto = null;
		Boolean result = null;
		String message = null;
		HttpStatus status = null;

		try {
			result = this.service.updateUser(id, userUpdate);

			if(result) {
				message = "User updated.";
				status = HttpStatus.CREATED;
			} else {
				message = "User not updated.";
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
			message = "Can not updated the user.";
			status = HttpStatus.BAD_REQUEST;
		} finally {
			dto = new ResponseDTO<>();
			dto.setObject(result);
			dto.setMessage(message);

			response = new ResponseEntity<ResponseDTO<Boolean>>(dto, status);
		}

		return response;
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseDTO<Boolean>> deleteTutorial(@PathVariable("id") long id) {
		ResponseEntity<ResponseDTO<Boolean>> response;
		ResponseDTO<Boolean> dto = null;
		Boolean result = null;
		String message = null;
		HttpStatus status = null;

		try {
			result = this.service.deleteUser(id);

			if(result) {
				message = "User deleted.";
				status = HttpStatus.CREATED;
			} else {
				message = "User not deleted.";
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
			message = "Can not deleted the user.";
			status = HttpStatus.BAD_REQUEST;
		} finally {
			dto = new ResponseDTO<>();
			dto.setObject(result);
			dto.setMessage(message);

			response = new ResponseEntity<ResponseDTO<Boolean>>(dto, status);
		}

		return response;
	}
}
