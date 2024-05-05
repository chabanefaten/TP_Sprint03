package com.faten.parfums.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.faten.parfums.entities.Parfum;
import com.faten.parfums.entities.Type;
import com.faten.parfums.service.ParfumService;

import jakarta.validation.Valid;

@Controller
public class ParfumController {
    @Autowired
    ParfumService parfumService;
    
    @GetMapping("/accessDenied")
    public String error()
    {
    return "accessDenied";
    }
    

    @GetMapping("/ListeParfums")
    public String listeParfums(ModelMap modelMap,
    		@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "2") int size)
    {
    	Page<Parfum> pars = parfumService.getAllParfumsParPage(page, size);
    	modelMap.addAttribute("parfums", pars);
    	modelMap.addAttribute("pages", new int[pars.getTotalPages()]);
    	modelMap.addAttribute("currentPage", page);
        return "listeParfums";
    }

    @GetMapping("/showCreate")
    public String showCreate(ModelMap modelMap)
    {
    	List<Type> typs = parfumService.getAllTypes();
    	modelMap.addAttribute("parfum", new Parfum());
    	modelMap.addAttribute("mode", "new");
    	modelMap.addAttribute("types", typs);
    	return "formParfum";

    }


    @PostMapping("/saveParfum")
    public String saveParfum(@Valid Parfum parfum,BindingResult bindingResult,
    		 @RequestParam(name="page", defaultValue = "0") int page,
             @RequestParam(name="size", defaultValue = "2") int size
    		
    		)
    		{
    	{
    		int currentPage;
    		boolean isNew = false;
    	          if (bindingResult.hasErrors()) return "formParfum";
    	 
    	           if (parfum.getIdParfum()==null) //ajout
    	        	   isNew=true;
    	           parfumService.saveParfum(parfum);
    	           if (isNew) //ajout
    	           {
    	           Page<Parfum> pars = parfumService.getAllParfumsParPage(page, size);
    	           currentPage = pars.getTotalPages()-1;
    	           }
    	           else //modif
    	           currentPage=page;

    	           
    	           return ("redirect:/ListeParfums?page="+currentPage+"&size="+size);

    		}}
    @GetMapping("/supprimerParfum")
    public String supprimerParfum(@RequestParam("id") Long id, ModelMap modelMap,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "2") int size)
     {
        parfumService.deleteParfumById(id);
        return "redirect:/ListeParfums?page=" + page + "&size=" + size;
    }


    @GetMapping("/modifierParfum")
    public String editerParfum(@RequestParam("id") Long id, ModelMap modelMap,
    		@RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "2") int size){
    	Parfum p= parfumService.getParfum(id);
    	List<Type> typs = parfumService.getAllTypes();
    	modelMap.addAttribute("parfum", p);
    	modelMap.addAttribute("mode", "edit");
    	modelMap.addAttribute("types", typs);
    	modelMap.addAttribute("page", page);
    	modelMap.addAttribute("size", size);
    	return "formParfum";

    }

    @PostMapping("/updateParfum")
    public String updateParfum(@ModelAttribute("parfum") Parfum parfum, @RequestParam("date") String date,
                               ModelMap modelMap) throws ParseException {
     
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateFormat.parse(date);
        parfum.setDateCreation(dateCreation);

        parfumService.updateParfum(parfum);
        return "redirect:/ListeParfums";
    }
}

