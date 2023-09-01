package com.skcet.liveConcert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcet.liveConcert.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
