package com.tia.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tia.language.models.Language;
import com.tia.language.repositories.LanguageRepository;
@Service
public class LanguageService {
    // adding the book repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the books
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    public Language updateLanguage(Language language) {
  
    	return languageRepository.save(language);
	}
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
		
	}
}