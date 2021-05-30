package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Image;


/**
 * 
 * @author teresafitzgerald
 *
 */
public interface ImageRepository extends JpaRepository<Image, Long> {

}