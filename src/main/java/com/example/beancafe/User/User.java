package com.example.beancafe.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @SequenceGenerator(
    name = "users_sequence",
    sequenceName = "users_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "users_sequence"
  )
  private Long id;
  private String email;
  private String name;
  private String address;
  private String phone;
  private Long cartId;


  public User(String email,String name, String address, String phone, Long cartId){
    this.email = email;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.cartId = cartId;
  }

}
