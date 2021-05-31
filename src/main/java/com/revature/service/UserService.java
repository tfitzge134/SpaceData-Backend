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

	public User registerUser(String username, String password, String firstName, String lastName, Long roleId) {
		if (username != null) {
			username = username.trim().toLowerCase();
		}

		try {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setRoleId(roleId);

			User userCreated = uRepo.save(user);
//			return "User created successfully";
			return userCreated;
		} catch (Exception e) {
			e.printStackTrace();
//			return "Error: User was not created";
			return null;
		}
	}

	public String updateUser(String username, String password, String firstName, String lastName, Long roleId) {
		if (username != null) {
			username = username.trim().toLowerCase();
		}

		try {
			User loggedInUser = loginUsername(username, password);
			if (loggedInUser == null) {
				return "Invalid User Credentials.";
			}
			loggedInUser.setFirstName(firstName);
			loggedInUser.setLastName(lastName);
			loggedInUser.setRoleId(roleId);

			User userCreated = uRepo.save(loggedInUser);
			if (userCreated != null) {
				return "User updated successfully";
			} else {
				return "Error: User was not updated";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error: User was not updated. Reason: " + e.getMessage();
		}
	}

	public User loginUsername(String username, String password) {
		if (username != null) {
			username = username.trim().toLowerCase();
		}
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
		if (username != null) {
			username = username.trim().toLowerCase();
		}
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
		if (username != null) {
			username = username.trim().toLowerCase();
		}
		try {
			return uRepo.findUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User findUserSession(String username, String sessionToken) {
		if (username != null) {
			username = username.trim().toLowerCase();
		}
		try {
			return uRepo.findUserByUsernameAndSessionToken(username, sessionToken);
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
