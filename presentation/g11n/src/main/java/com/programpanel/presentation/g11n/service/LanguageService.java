package com.programpanel.presentation.g11n.service;

import com.programpanel.presentation.g11n.entity.Iso639Language;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public record LanguageService() {
    public Set<Iso639Language> getSupportedLanguages() {
        return Arrays.stream(Iso639Language.values()).collect(Collectors.toSet());
    }
}
