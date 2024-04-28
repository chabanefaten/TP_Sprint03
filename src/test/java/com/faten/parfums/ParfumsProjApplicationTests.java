package com.faten.parfums;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.faten.parfums.entities.Parfum;
import com.faten.parfums.entities.Type;
import com.faten.parfums.repos.ParfumRepository;


@SpringBootTest
class ParfumsProjApplicationTests {

	@Autowired
	private ParfumRepository parfumRepository;
	/*
	 * @Autowired private ParfumService parfumService;
	 */
	

	/*
	 * @Test public void testFindByNomParfumContains() { Page<Parfum> pars =
	 * parfumService.getAllParfumsParPage(0,2); System.out.println(pars.getSize());
	 * System.out.println(pars.getTotalElements());
	 * System.out.println(pars.getTotalPages()); pars.getContent().forEach(p ->
	 * {System.out.println(p.toString()); }); }
	 */
	
	@Test
	public void testCreateParfum() {
	Parfum pars = new Parfum("You",2500.500,new Date());
	parfumRepository.save(pars);
	}
	
	@Test
	public void testFindParfum()
	{
	Parfum p = parfumRepository.findById(1L).get(); 
	System.out.println(p);
	}
	@Test
	public void testUpdateParfum()
	{
	Parfum p = parfumRepository.findById(1L).get();
	p.setPrixParfum(1000.0);
	parfumRepository.save(p);
	System.out.println(p);
	}
    
	@Test
	public void testDeleteParfum()
	{
	parfumRepository.deleteById(27L);;
	}
	
	 
	@Test
	public void testListerTousParfums()
	{
	List<Parfum> pars = parfumRepository.findAll();
	for (Parfum p : pars)
	{
	System.out.println(p);
	}
	}
	
	
	 @Test
	 public void testFindByNomParfum()
	 {
	 List<Parfum> pars = parfumRepository.findByNomParfum("You");
	 for (Parfum p : pars)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testFindParfumByNomContains ()
	 {
	 List<Parfum> pars=parfumRepository.findByNomParfumContains("Y");
	 for (Parfum p : pars)
	 {
	 System.out.println(p);
	 } }
	 
	 
	 @Test
	 public void testfindByNomPrix()
	 {
	 List<Parfum> pars = parfumRepository.findByNomPrix("You", 1000.500);
	 for (Parfum p : pars)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testfindByType()
	 {
	 Type typ = new Type();
	 typ.setIdTyp(1L);
	 List<Parfum> pars = parfumRepository.findByType(typ);
	 for (Parfum p : pars)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void findByTypeIdTyp()
	 {
	 List<Parfum> pars = parfumRepository.findByTypeIdTyp(1L);
	 for (Parfum p : pars)
	 {
	 System.out.println(p);
	 }
	  }
	 
	 @Test
	 public void testfindByOrderByNomParfumAsc()
	 {
	 List<Parfum> pars = 
	 parfumRepository.findByOrderByNomParfumAsc();
	 for (Parfum p : pars)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testTrierParfumsNomsPrix()
	 {
	 List<Parfum> pars = parfumRepository.trierParfumsNomsPrix();
	 for (Parfum p : pars)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 
	}
	



