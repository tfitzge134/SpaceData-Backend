package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.AlbumJunction;


/**
 * 
 * @author teresafitzgerald
 *
 */
public interface AlbumJunctionRepository extends JpaRepository<AlbumJunction, Long> {

}