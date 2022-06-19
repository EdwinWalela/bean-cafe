package com.example.beancafe.User;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.dao.EmptyResultDataAccessException;
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

import com.example.beancafe.ResponseHandler.ResponseHandler;

@RestController()
@RequestMapping(path = "/api/v1/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}

	@GetMapping()
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") Long id){
		User user = new User();
		try {
			user = this.userService.getUser(id);
		} catch(NoSuchElementException e){
			return ResponseHandler.generateResponse("User not found", HttpStatus.NOT_FOUND, null);
		} catch (Exception e) {
		  return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		return 	ResponseHandler.generateResponse("ok", HttpStatus.OK, user);
	}

	@PostMapping()
	public ResponseEntity<Object> createUser(@RequestBody User req){
		User user = new User();

		try {
			user = this.userService.createUser(req); 
		} catch(IllegalArgumentException e){
			return ResponseHandler.generateResponse("Email already in use", HttpStatus.BAD_REQUEST, null);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE, null);
		}
		return ResponseHandler.generateResponse("User created", HttpStatus.CREATED, user);
		 
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User req, @PathVariable("id") Long id){
		User user = new User();;
		try {
			user = this.userService.updateUser(req, id);
		} catch(NoSuchElementException e){
			return ResponseHandler.generateResponse("User not found", HttpStatus.NOT_FOUND, null);
		}catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		return ResponseHandler.generateResponse("User updated", HttpStatus.OK, user);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id){
		try {
			this.userService.deleteUser(id);
		}catch(EmptyResultDataAccessException e){
			return ResponseHandler.generateResponse("User not found", HttpStatus.NOT_FOUND, null);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		return ResponseHandler.generateResponse("User deleted", HttpStatus.OK, null);
	}	

}
