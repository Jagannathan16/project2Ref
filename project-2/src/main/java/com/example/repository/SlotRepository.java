package com.example.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.BookSlot;

@Repository
public interface SlotRepository extends JpaRepository<BookSlot, Integer>{

	public List<BookSlot> findByName(String name);
}
