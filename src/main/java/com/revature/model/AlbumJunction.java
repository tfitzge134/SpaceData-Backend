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
@Table(name = "album_junction")
public class AlbumJunction {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "album_id")
	private Long albumId;

	@Column(name = "image_id")
	private Long imageId;

	public AlbumJunction() {
		super();
	}

	public AlbumJunction(Long albumId, Long imageId) {
		super();
		this.albumId = albumId;
		this.imageId = imageId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	@Override
	public String toString() {
		return "AlbumJunction [albumId=" + albumId + ", imageId=" + imageId + "]";
	}

}
