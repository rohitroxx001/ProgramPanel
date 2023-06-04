package com.programpanel.presentation.cli.provider;

import com.programpanel.presentation.g11n.entity.Iso639Language;
import com.programpanel.presentation.g11n.service.LanguageService;
import java.util.List;
import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;
import org.springframework.shell.standard.ValueProvider;
import org.springframework.stereotype.Component;

@Component
public record LanguageValueProvider(LanguageService languageService) implements ValueProvider {
    @Override
    public List<CompletionProposal> complete(CompletionContext completionContext) {
        return languageService.getSupportedLanguages().stream().map(this::toProposal).toList();
    }

    public CompletionProposal toProposal(Iso639Language language) {
        return new CompletionProposal(language.languageCode()).description(language.languageName());
    }
}
