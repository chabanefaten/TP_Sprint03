package com.faten.parfums.entities;


import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomPars", types = { Parfum.class })
public interface ParfumProjection {
	
	public String getNomParfum();
	}


