package com.skcet.liveConcert.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skcet.liveConcert.model.Audience;

import jakarta.transaction.Transactional;


public interface AudienceRepository extends JpaRepository<Audience, Long>{
	    boolean existsByEmail(String email);
		Optional<Audience> findById(Long id);
		void deleteById(Long id);
		
		//pagination
		List<Audience> findByName(String name);
	    
		//jpql without native query
		@Query("select a from Audience a")
		List<Audience> findAllQuery();
		
		//jpql with native query
		@Query(value="select * from _audience where email=?1",nativeQuery = true)
	     Audience findByEmail(String email);
		
		//update query without native query
		@Modifying
		@Transactional
		@Query("update Audience a set a.name = :Name where a.id = :id")
		void updateUserDetails(@Param("Name") String fname, @Param("id") Long id);
		
		//delete query with native query
		@Modifying
		@Transactional
		@Query(value = "delete from _audience where id = ?1", nativeQuery = true)
		int deleteByIdQuery(Long id);

}
