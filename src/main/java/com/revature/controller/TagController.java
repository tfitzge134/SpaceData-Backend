package com.revature.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Tag;
import com.revature.service.TagService;

/**
 * 
 * @author teresafitzgerald
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/tag")
public class TagController {

	private TagService uServ;

	@Autowired
	public TagController(TagService serv) {
		this.uServ = serv;
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Tag> createTag(@RequestBody LinkedHashMap<String, String> map) {
		String sessionToken = map.get("sessionToken");
		Tag tag = uServ.createTag(sessionToken, map.get("tagName"));
		return new ResponseEntity<Tag>(tag, HttpStatus.OK);
	}

}
