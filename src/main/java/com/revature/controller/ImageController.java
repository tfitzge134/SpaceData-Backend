package com.revature.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.ImageService;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

	private ImageService uServ;

	@Autowired
	public ImageController(ImageService serv) {
		this.uServ = serv;
	}

	@PostMapping(value = "/create")
	public ResponseEntity<String> createImage(@RequestBody LinkedHashMap<String, String> map) {
		String sessionToken = map.get("sessionToken");
		String userIdStr = map.get("userId");
		long userId;
		if ((userIdStr == null) || userIdStr.trim().equals("")) {
			userId = -1;
		} else {
			userId = Long.parseLong(userIdStr);
		}
		String albumIdStr = map.get("albumId");
		long albumId;
		if ((albumIdStr == null) || albumIdStr.trim().equals("")) {
			albumId = -1;
		} else {
			albumId = Long.parseLong(albumIdStr);
		}
		String message = uServ.createImage(userId, sessionToken, map.get("title"), albumId, map.get("mediaType"),
				map.get("url"), map.get("hdurl"));
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
