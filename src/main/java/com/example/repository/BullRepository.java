package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.BullEntity;

public interface BullRepository extends JpaRepository<BullEntity, Long> {
	
	public BullEntity findById(int id);
	public void deleteById(int id);
	

}
