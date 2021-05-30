package com.revature.controller;

import java.util.Date;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Image;
import com.revature.service.AlbumJunctionService;
import com.revature.service.ImageService;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

	private ImageService uServ;
	private AlbumJunctionService albJunServ;

	@Autowired
	public ImageController(ImageService serv, AlbumJunctionService albJunServ) {
		this.uServ = serv;
		this.albJunServ = albJunServ;
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Image> createImage(@RequestBody LinkedHashMap<String, String> map) {
		String sessionToken = map.get("sessionToken");
		String userIdStr = map.get("userId");
		long userId = 0;
		if ((userIdStr != null) && !userIdStr.trim().equals("")) {
			userId = Long.parseLong(userIdStr);
		}
		String albumIdStr = map.get("albumId");
		long albumId = 0;
		if ((albumIdStr != null) && !albumIdStr.trim().equals("")) {
			albumId = Long.parseLong(albumIdStr);
		}
		Date imageDt = new Date();
		Image image = uServ.createImage(userId, sessionToken, map.get("title"), map.get("mediaType"), map.get("url"),
				map.get("hdurl"), imageDt);
		if (image != null) {
			Long imageId = image.getImageId();
			albJunServ.createAlbumJunction(userId, sessionToken, albumId, imageId);
		}
		return new ResponseEntity<Image>(image, HttpStatus.OK);
	}

}
