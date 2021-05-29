package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Image;
import com.revature.repository.ImageRepository;

@Service
public class ImageService {

	private ImageRepository imageRepo;
	private UserService userService;

	public ImageService() {

	}

	@Autowired
	public ImageService(ImageRepository imageRepo, UserService userService) {
		this.imageRepo = imageRepo;
		this.userService = userService;
	}

	public String createImage(Long userId, String sessionToken, String title, Long albumId, String mediaType,
			String url, String hdurl) {
		try {
//			boolean validSession = userService.isValidSession(userId, sessionToken);
//			if (!validSession) {
//				return "Error: Image was not created. INVALID Session.";
//			}
			Image image = new Image(title, userId, albumId, mediaType, url, hdurl);
			imageRepo.save(image);
			return "Image created successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error: Image was not created";
		}
	}

}
