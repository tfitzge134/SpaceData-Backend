package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Tag;
import com.revature.repository.TagRepository;

/**
 * 
 * @author teresafitzgerald
 *
 */
@Service
public class TagService {

	private TagRepository tagRepo;
	private UserService userService;

	public TagService() {

	}

	@Autowired
	public TagService(TagRepository tagRepo, UserService userService) {
		this.tagRepo = tagRepo;
		this.userService = userService;
	}

	public Tag createTag(String sessionToken, String tagName) {
		try {
//			boolean validSession = userService.isValidSession(userId, sessionToken);
//			if (!validSession) {
//				return "Error: Tag was not created. INVALID Session.";
//			}
			Tag tag = new Tag(tagName);
			tagRepo.save(tag);
			return tag;
//			return "Tag created successfully";
		} catch (Exception e) {
			e.printStackTrace();
//			return "Error: Tag was not created";
			return null;
		}
	}

}
