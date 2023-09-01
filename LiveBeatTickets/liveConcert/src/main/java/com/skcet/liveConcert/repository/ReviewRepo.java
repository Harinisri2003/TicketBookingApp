package com.skcet.liveConcert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcet.liveConcert.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Long>{

}
