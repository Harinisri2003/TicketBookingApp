package com.skcet.liveConcert.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.skcet.liveConcert.model.Audience;
import com.skcet.liveConcert.repository.AudienceRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class ConcertServiceImpl implements ConcertService{
    @Autowired
	private AudienceRepository audienceRepository;
	@Override
	public boolean addValue(Audience audience) {
		// TODO Auto-generated method stub
		boolean eventIdExists= audienceRepository.existsByEmail(audience.getEmail());
		if(!eventIdExists)
		{
			audienceRepository.save(audience);
			return true;
		}
		else
		return false;
	}
	
	@Override
	public List<Audience> getValue() {
		return audienceRepository.findAll();
	}

	@Override
	public boolean updateConcert(Long id,Audience audience) {
//		userRepository.saveAndFlush(concertModel);
		
		Optional<Audience>existingUserOptional=audienceRepository.findById(id);
		if(existingUserOptional.isPresent())
		{
			Audience concertExists=existingUserOptional.get();
		concertExists.setName(audience.getName());
		concertExists.setEmail(audience.getEmail());
		concertExists.setPassword(audience.getPassword());
		concertExists.setPhoneNumber(audience.getPhoneNumber());
		audienceRepository.save(concertExists);
		return true;
		}
		else
		{
			return false;
			
		}
	}

	@Override
	public boolean deleteConcert(Long id) {
		// TODO Auto-generated method stub
		Optional<Audience> existingUserOptional=audienceRepository.findById(id);
		if(existingUserOptional.isPresent())
		{
			audienceRepository.deleteById(id);
			return true;
		}
		else
		return false;
	}

	@Override
	public Page<Audience> getPagesWithSort(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return audienceRepository.findAll(pageRequest);
	}

	@Override
	public List<Audience> getAllQuery() {
		// TODO Auto-generated method stub
		return audienceRepository.findAllQuery();
	}

	@Override
	public Audience getQueryByEmail(String email) {
		// TODO Auto-generated method stub
		return audienceRepository.findByEmail(email);
	}

	@Override
	public void updateNameQuery(String name, Long id) {
		// TODO Auto-generated method stub
		audienceRepository.updateUserDetails(name, id);
	}

	@Override
	public int deleteQuery(Long id) {
		// TODO Auto-generated method stub
		return audienceRepository.deleteByIdQuery(id);
	}

}
