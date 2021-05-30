package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.AlbumJunction;

public interface AlbumJunctionRepository extends JpaRepository<AlbumJunction, Long> {

}