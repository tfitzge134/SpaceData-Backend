package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * 
 * @author teresafitzgerald
 *
 */
@Entity
@Component
@Table(name = "tag_junction")
public class TagJunction {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tag_id")
	private Long tagId;

	@Column(name = "image_id")
	private Long imageId;

	public TagJunction() {
		super();
	}

	public TagJunction(Long tagId, Long imageId) {
		super();
		this.tagId = tagId;
		this.imageId = imageId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	@Override
	public String toString() {
		return "TagJunction [tagId=" + tagId + ", imageId=" + imageId + "]";
	}

}
