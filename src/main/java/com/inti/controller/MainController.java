package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

}
