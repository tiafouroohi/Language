package com.tia.language.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tia.language.models.Language;
import com.tia.language.services.LanguageService;

@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/")
	public String index(Model model,@ModelAttribute("language")Language language) {
		model.addAttribute("allLanguages", languageService.allLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/language")
	public String create(@Valid @ModelAttribute("language")Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		languageService.createLanguage(language);
		
		return "redirect:/";
	}

	
	@RequestMapping("/language/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/language/{id}", method=RequestMethod.POST)
	public String update(@PathVariable("id")Long id, Model model,@Valid @ModelAttribute("language")Language language, BindingResult result) {
		model.addAttribute("id", id);
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			languageService.updateLanguage(language);
			return "redirect:/";
			}
		}
	@RequestMapping(value="/language/{id}/delete")
	public String destroy(@PathVariable("id")Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/";
	}
}

