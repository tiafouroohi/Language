package com.tia.language.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tia.language.models.Language;
import com.tia.language.services.LanguageService;

@RestController
public class MainController {
    private final LanguageService languageService;
    public MainController(LanguageService languageService){
        this.languageService = languageService;
    }
    @RequestMapping("/api/language")
    public List<Language> index() {
        return languageService.allLanguages();
    }
    
    @RequestMapping(value="/api/language", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") Double version) {
        Language language = new Language(name, creator, version);
        return languageService.createLanguage(language);
    }
    
    @RequestMapping("/api/language/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = languageService.findLanguage(id);
        return language;
    }
}