package com.programpanel.presentation.cli.command;

import com.programpanel.presentation.cli.provider.LanguageValueProvider;
import com.programpanel.presentation.g11n.entity.Iso639Language;
import com.programpanel.presentation.g11n.service.LanguageService;
import java.util.Locale;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public record ChangeLanguageCommand(LanguageService languageService) {
    @ShellMethod("Change language.")
    public String changeLanguage(@ShellOption(valueProvider = LanguageValueProvider.class) String language) {
        final var languages = languageService.getSupportedLanguages();
        final var languageCodes = languages.stream().map(Iso639Language::languageCode).toList();
        if (!languageCodes.contains(language)) {
            return "Language not supported: " + language;
        }
        Locale.setDefault(Locale.of(language));
        return "Language changed to: " + language;
    }
}
