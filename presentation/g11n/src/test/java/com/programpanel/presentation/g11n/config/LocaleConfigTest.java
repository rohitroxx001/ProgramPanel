package com.programpanel.presentation.g11n.config;

import java.util.Locale;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LocaleConfig.class)
public class LocaleConfigTest {
    @Autowired
    private MessageSource messageSource;

    @ParameterizedTest
    @CsvSource({
            "en, Hi",
            "en_US, Hi",
            "en_GB, Hi",
            "no, Hei",
            "hr, Bok",
    })
    public void testInformalGreetingInDifferentLocales(String language, String expected) {
        final var locale = Locale.of(language);
        final var actual = messageSource.getMessage("informal.greeting", null, locale);
        assertEquals(expected, actual);
    }
}
