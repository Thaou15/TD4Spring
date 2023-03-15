package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.inti.model.Voiture;
import com.inti.repository.IVoitureRepository;

@Controller
public class MainController {
	@Autowired
	IVoitureRepository ivr;
	
	@GetMapping("ajout")
	public String ajoutVoiture()
	{
		return"formVoiture";
	}
	@PostMapping("save")
	public String saveVoiture(@ModelAttribute ("voiture") Voiture v)
	{
		 ivr.save(v);
			
		return "redirect:/ajout";
	}
	
	@GetMapping("listeV")
	public String listeVoiture(Model m)
	{
	    m.addAttribute("listeV",ivr.findAll());
		return"listeV";
	}
	
	@GetMapping("getVoiture")
	public String getVoiture(@RequestParam("id") int id, Model m)
	{
		Voiture v = ivr.findById(id).get();
		
		m.addAttribute("voiture", v);
		return"afficherVoiture";
	}
	
	@GetMapping("delete/{id}")
	public String deleteVoiture(@PathVariable int id)
	{
		ivr.deleteById(id);
		
		return "listeV";
	}

}
