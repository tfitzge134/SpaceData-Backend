package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.AlbumJunction;
import com.revature.repository.AlbumJunctionRepository;


/**
 * 
 * @author teresafitzgerald
 *
 */
@Service
public class AlbumJunctionService {

	private AlbumJunctionRepository albumRepo;
	private UserService userService;

	public AlbumJunctionService() {

	}

	@Autowired
	public AlbumJunctionService(AlbumJunctionRepository albumRepo, UserService userService) {
		this.albumRepo = albumRepo;
		this.userService = userService;
	}

	public String createAlbumJunction(Long userId, String sessionToken, Long albumId, Long imageId) {
		try {
//			boolean validSession = userService.isValidSession(userId, sessionToken);
//			if (!validSession) {
//				return "Error: AlbumJunction was not created. INVALID Session.";
//			}
			albumRepo.save(new AlbumJunction(albumId, imageId));
			return "AlbumJunction created successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error: AlbumJunction was not created";
		}
	}

}
