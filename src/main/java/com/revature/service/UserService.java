package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.util.SessionUtil;

/**
 * 
 * @author teresafitzgerald
 *
 */
@Service
public class UserService {

	private UserRepository uRepo;

	public UserService() {

	}

	@Autowired
	public UserService(UserRepository repo) {
		this.uRepo = repo;
	}

	public User registerUser(String username, String password) {
		try {
			User userCreated = uRepo.save(new User(username, password));
//			return "User created successfully";
			return userCreated;
		} catch (Exception e) {
			e.printStackTrace();
//			return "Error: User was not created";
			return null;
		}
	}

	public User loginUsername(String username, String password) {
		try {
			User loggedIn = uRepo.findUserByUsernameAndPassword(username, password);
			if (loggedIn == null) {
				return null;
//				return "User login failed";
			} else {
				String sessionToken = SessionUtil.createSessionToken();
				loggedIn.setSessionToken(sessionToken);
				loggedIn.setLoggedOn(true);
				uRepo.save(loggedIn);
				return loggedIn;
//				return "User logged in successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
//			return "User login failed";
			return null;
		}
	}

	public boolean logoutUsername(String username) {
		try {
			User loggedIn = uRepo.findUserByUsername(username);
			if (loggedIn != null) {
				loggedIn.setSessionToken(null);
				loggedIn.setLoggedOn(false);
				uRepo.save(loggedIn);
//				return "User logged out successfully.";

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
//			return "User login failed";
			return false;
		}
	}

	public boolean isValidSession(Long userId, String sessionToken) {
		Optional<User> found = uRepo.findById(userId);
		boolean validSession = false;
		if (found.isPresent()) {
			User user = found.get();
			validSession = (user.getSessionToken() != null) && user.getSessionToken().equals(sessionToken);
		}
		return validSession;
	}

	public User searchUsers(String username) {
		try {
			return uRepo.findUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getLoggedOnUsers() {
		try {
			return uRepo.findUserByLoggedOn(true);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
