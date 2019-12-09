package com.waracle.cakemgr.cake.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waracle.cakemgr.cake.Model.Cake;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long>{
	List<Cake> findByTitle(String title); //if finding by different attributes is needed...
}