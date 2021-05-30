package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Tag;


/**
 * 
 * @author teresafitzgerald
 *
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

}