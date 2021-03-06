package com.revature.model;

import java.util.Date;

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
@Table(name = "spaceapi_image")
public class Image {

	@Id
	@Column(name = "image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imageId;

	@Column(name = "title", unique = true, nullable = true)
	private String title;

	@Column(name = "media_type", unique = true, nullable = false)
	private String mediaType;

	@Column(name = "url", unique = true, nullable = false)
	private String url;

	@Column(name = "hdurl", unique = true, nullable = false)
	private String hdurl;

	@Column(name = "image_dt", nullable = false)
	private Date imageDt;

	@Column(name = "notes", unique = true, nullable = true)
	private String notes;

	@Column(name = "user_id", nullable = false)
	private Long userId;

	public Image() {
		super();
	}

	public Image(String title, Long userId, String mediaType, String url, String hdurl, Date imageDt) {
		super();
		this.title = title;
		this.mediaType = mediaType;
		this.url = url;
		this.hdurl = hdurl;
		this.userId = userId;
		this.imageDt = imageDt;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHdurl() {
		return hdurl;
	}

	public void setHdurl(String hdurl) {
		this.hdurl = hdurl;
	}

	public Date getImageDt() {
		return imageDt;
	}

	public void setImageDt(Date imageDt) {
		this.imageDt = imageDt;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", title=" + title + ", mediaType=" + mediaType + ", url=" + url
				+ ", hdurl=" + hdurl + ", imageDt=" + imageDt + ", notes=" + notes + ", userId=" + userId + "]";
	}

}
