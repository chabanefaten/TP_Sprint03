package com.faten.parfums.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faten.parfums.entities.Parfum;
import com.faten.parfums.service.ParfumService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ParfumRESTController {
	
	@Autowired
	ParfumService parfumService;
	
	 @GetMapping
	    public List<Parfum> getAllParfums() {
	        return parfumService.getAllParfums();
	    }
	 
	  @GetMapping("/{id}")
	    public Parfum getParfumById(@PathVariable("id") Long id) {
	        return parfumService.getParfum(id);
	    }
	  @PostMapping
	    public Parfum createParfum(@RequestBody Parfum parfum) {
	        return parfumService.saveParfum(parfum);
	    }
	  
	  @PutMapping
	  public Parfum updateParfum(@RequestBody Parfum parfum) {
	  return parfumService.updateParfum(parfum);
	  }

	  @DeleteMapping("/{id}")
	    public void deleteParfum(@PathVariable("id") Long id) {
	        parfumService.deleteParfumById(id);
	    }

	  @GetMapping("/parstyp/{idTyp}")
	    public List<Parfum> getParfumsByTypId(@PathVariable("idTyp") Long idTyp) {
	        return parfumService.findByTypeIdTyp(idTyp);
	    }
	  @GetMapping("/parsByName/{nom}")
	  public List<Parfum> findByNomParfumContains(@PathVariable("nom") String nom) {
	  return parfumService.findByNomParfumContains(nom);
	  }

	  
	  
	  
}



