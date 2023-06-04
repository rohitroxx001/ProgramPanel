package com.programpanel.presentation.api.controller;

import com.programpanel.presentation.g11n.service.MessageService;
import java.util.Locale;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MessageService messageService;

    @ParameterizedTest
    @ValueSource(strings = {"en", "en_US", "en_GB", "no", "hr"})
    public void testInformalGreetingInDifferentLocales(String language) throws Exception {
        final var locale = Locale.of(language);
        final var expected = messageService.getMessage("informal.greeting", locale);
        this.mockMvc.perform(get("/informal-greeting").header("Accept-Language", language))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }
}
