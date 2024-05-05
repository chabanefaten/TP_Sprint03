package com.faten.parfums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.faten.parfums.entities.Parfum;
import com.faten.parfums.entities.Type;
import com.faten.parfums.repos.ParfumRepository;
import com.faten.parfums.repos.TypeRepository;

@Service
public class ParfumServiceImpl implements ParfumService {
	@Autowired
	ParfumRepository parfumRepository;
	
	@Autowired
	TypeRepository typeRepository;


	@Override
	public Parfum saveParfum(Parfum p) {
		return parfumRepository.save(p);
	}

	@Override
	public Parfum updateParfum(Parfum p) {
		return parfumRepository.save(p);
	}

	@Override
	public void deleteParfum(Parfum p) {
		parfumRepository.delete(p);
	}

	@Override
	public void deleteParfumById(Long id) {
		parfumRepository.deleteById(id);
	}

	@Override
	public Parfum getParfum(Long id) {
		return parfumRepository.findById(id).get();
	}

	@Override
	public List<Parfum> getAllParfums() {
		return parfumRepository.findAll();

	}
	
	  @Override
	  public Page<Parfum> getAllParfumsParPage(int page, int size) {
	 return parfumRepository.findAll(PageRequest.of(page, size)); }
	 

	@Override
	public List<Parfum> findByNomParfum(String nom) {
	return parfumRepository.findByNomParfum(nom);
	}
	@Override
	public List<Parfum> findByNomParfumContains(String nom) {
	return parfumRepository.findByNomParfumContains(nom);
	}
	@Override
	public List<Parfum> findByNomPrix(String nom, Double prix) {
	return parfumRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Parfum> findByType(Type type) {
	return parfumRepository.findByType(type);
	}
	@Override
	public List<Parfum> findByTypeIdTyp(Long id) {
	return parfumRepository.findByTypeIdTyp(id);
	}
	@Override
	public List<Parfum> findByOrderByNomParfumAsc() {
	return parfumRepository.findByOrderByNomParfumAsc();
	}
	@Override
	public List<Parfum> trierParfumsNomsPrix() {
	return parfumRepository.trierParfumsNomsPrix();

}

	@Override
	public List<Type> getAllTypes() {
		return typeRepository.findAll();
		
	}
}