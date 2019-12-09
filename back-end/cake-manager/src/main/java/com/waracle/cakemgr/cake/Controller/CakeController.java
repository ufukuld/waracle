package com.waracle.cakemgr.cake.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waracle.cakemgr.cake.Model.Cake;
import com.waracle.cakemgr.cake.Service.CakeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CakeController {

	@Autowired
	CakeService cakeService;
	
	@RequestMapping("/cakes")
	public List<Cake> getCakeList() {
		return cakeService.getCakeList();
	}
	
	@PostMapping("/cakes")
	public void addCake(@RequestBody Cake cake) {
		cakeService.addCake(cake);
	}
}