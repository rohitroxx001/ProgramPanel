package com.programpanel.presentation.cli.command;

import java.util.Locale;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ChangeLanguageCommandTest {
    @Autowired
    private ChangeLanguageCommand changeLanguageCommand;

    @ParameterizedTest
    @ValueSource(strings = {
            "en", // English
            "no", // Norwegian
            "hr", // Croatian
    })
    public void testChangeToSupportedLanguage(String language) {
        final var output = changeLanguageCommand.changeLanguage(language);
        assertEquals("Language changed to: " + language, output);
        assertEquals(Locale.of(language), Locale.getDefault());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ab", // Abkhazian
            "aa", // Afar
            "af", // Afrikaans
            "ak", // Akan
            "sq", // Albanian
            "am", // Amharic
            "ar", // Arabic
            "an", // Aragonese
    })
    public void testChangeToUnsupportedLanguage(String language) {
        final var defaultLocale = Locale.getDefault();
        final var output = changeLanguageCommand.changeLanguage(language);
        assertEquals("Language not supported: " + language, output);
        assertEquals(defaultLocale, Locale.getDefault());
    }
}
