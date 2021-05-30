package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Album;
import com.revature.repository.AlbumRepository;


/**
 * 
 * @author teresafitzgerald
 *
 */
@Service
public class AlbumService {

	private AlbumRepository albumRepo;
	private UserService userService;

	public AlbumService() {

	}

	@Autowired
	public AlbumService(AlbumRepository albumRepo, UserService userService) {
		this.albumRepo = albumRepo;
		this.userService = userService;
	}

	public String createAlbum(Long userId, String sessionToken, String albumName) {
		try {
//			boolean validSession = userService.isValidSession(userId, sessionToken);
//			if (!validSession) {
//				return "Error: Album was not created. INVALID Session.";
//			}
			albumRepo.save(new Album(albumName, userId));
			return "Album created successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error: Album was not created";
		}
	}

}
