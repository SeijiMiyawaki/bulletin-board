package com.example.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.BullEntity;

public interface BullRepository extends JpaRepository<BullEntity, Long> {
	
	public BullEntity findById(Date createDate);
	public void deleteById(Date createDate);
	

}
