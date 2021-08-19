package com.example.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.api.TimeEntity;
import com.example.model.BookSlot;

@Repository
public interface SlotRepository extends JpaRepository<BookSlot, Integer>{

	public List<BookSlot> findByName(String name);
	
	@Query("select b from BookSlot b where b.sport =:game and b.date =:date")
	public List<BookSlot> findByGame(String game, String date);
}
