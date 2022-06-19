package com.example.beancafe.User;

import java.util.List;
import java.util.NoSuchElementException;

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
	public User getUser(@PathVariable("id") Long id){
		return this.userService.getUser(id);
	}

	@PostMapping()
	public User createUser(@RequestBody User user){
		return this.userService.createUser(user); 
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User req, @PathVariable("id") Long id){
		User user = new User();;
		try {
			user = this.userService.updateUser(req, id);
		} catch(NoSuchElementException e){
			return ResponseHandler.generateResponse("User not found", HttpStatus.NOT_FOUND, user);
		}catch (Exception e) {
			return ResponseHandler.generateResponse("Update failed", HttpStatus.BAD_REQUEST, user);
		}
		return ResponseHandler.generateResponse("User updated", HttpStatus.OK, user);
	}

	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable("id") Long id){
		this.userService.deleteUser(id);
		return String.format("User %d deleted", id);
	}	

}
