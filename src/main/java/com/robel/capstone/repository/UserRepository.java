package com.robel.capstone.repository;

import com.robel.capstone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * author: Robel
 *  this model defines a method named findByEmail that takes a String parameter named email and returns a User object.
 *  It is used to search for a user by their email address.
 */


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   User findByEmail(String email);


}
