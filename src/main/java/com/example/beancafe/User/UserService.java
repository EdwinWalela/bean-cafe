package com.example.beancafe.User;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service()
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public List<User> getUsers(){
    return this.userRepository.findAll();
  }

  public User getUser(Long id){
      return this.userRepository.findById(id).orElseThrow(
        () -> new NoSuchElementException()
      );
  }

  public User createUser(User user){
    Boolean exists = this.userRepository.findUserByEmail(user.getEmail()).isPresent();
    if (exists){
      throw new IllegalArgumentException("Email in use");
    }
    return this.userRepository.save(user);
  }

  @Transactional
  public User updateUser(User req, Long id){
    User user = this.userRepository.findById(id).orElseThrow(
      () -> new NoSuchElementException()
    ); 
    if(req.getName() != null && req.getName().length() > 0){
      user.setName(req.getName());
    }
    if(req.getAddress() != null && req.getAddress().length() > 0){
      user.setAddress(req.getAddress());
    }
    if(req.getPhone() != null && req.getPhone().length() > 0){
      user.setPhone(req.getPhone());
    }
    return user;
  }

  public void deleteUser(Long id){
    this.userRepository.deleteById(id);
  }
}
