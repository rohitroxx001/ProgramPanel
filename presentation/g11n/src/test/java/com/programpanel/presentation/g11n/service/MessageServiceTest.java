package com.programpanel.presentation.g11n.service;

import com.programpanel.presentation.g11n.config.LocaleConfig;
import java.util.Locale;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {LocaleConfig.class, MessageService.class})
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @ParameterizedTest
    @CsvSource({
            "en, Hi",
            "en_US, Hi",
            "en_GB, Hi",
            "no, Hei",
            "hr, Bok",
    })
    public void testGetMessage(String language, String expected) {
        final var locale = Locale.of(language);
        final var actual = messageService.getMessage("informal.greeting", locale);
        assertEquals(expected, actual);
    }
}
