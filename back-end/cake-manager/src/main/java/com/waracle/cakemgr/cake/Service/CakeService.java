package com.waracle.cakemgr.cake.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waracle.cakemgr.cake.Model.Cake;
import com.waracle.cakemgr.cake.Repository.CakeRepository;

@Service
public class CakeService {
	
	@Autowired
	CakeRepository cakeRepository;

	public List<Cake> getCakeList() {
		return cakeRepository.findAll();
	}
	
	public Cake getCakeById(Long id) {
		return cakeRepository.findById(id).get();
	}

	public void addCake(Cake cake) {
		cakeRepository.save(cake);		
	}

	public void deleteCake(Long id) {
		cakeRepository.deleteById(id);
	}
}
