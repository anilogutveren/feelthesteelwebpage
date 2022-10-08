package com.feelthesteel.band.webpage.repository;


import com.feelthesteel.band.webpage.dto.PageCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageCalledRepository extends JpaRepository<PageCall, Long> {
}