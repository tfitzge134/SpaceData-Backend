package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.User;

/**
 * 
 * @author teresafitzgerald
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

//	User findUserByUsernameOrEmail(String username, String email);

	User findUserByUsernameAndPassword(String username, String password);

	User findUserByUsernameAndSessionToken(String username, String sessionToken);

	User findUserByUsername(String username);

	List<User> findUserByLoggedOn(boolean loggedOn);

//	@Query("SELECT u FROM user u WHERE u.logged_on = true")
//	List<User> findAllLoggedOnUsers();
}
