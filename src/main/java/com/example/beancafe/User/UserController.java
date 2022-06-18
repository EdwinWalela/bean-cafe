package com.example.beancafe.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/api/v1/users")
public class UserController {

	@GetMapping()
	public void getUsers(){

	}
	@GetMapping(path = "/{id}")
	public void getUser(@PathVariable("id") Long id){

	}

	@PostMapping()
	public void createUser(@RequestBody User user){

	}

	@PutMapping(path = "/{id}")
	public void updateUser(@RequestBody User user, @PathVariable("id") Long id){

	}

	@DeleteMapping(path = "/{id}")
	public void deleteUser(@PathVariable("id") Long id){
		
	}	

}
