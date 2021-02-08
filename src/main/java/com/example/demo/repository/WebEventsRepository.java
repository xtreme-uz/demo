package com.example.demo.repository;

import com.example.demo.entity.WebEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebEventsRepository extends JpaRepository<WebEvents, Long> {
}
