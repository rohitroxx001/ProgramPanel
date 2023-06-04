package com.programpanel.presentation.api.controller;

import com.programpanel.presentation.g11n.service.MessageService;
import java.util.Locale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record GreetingController(MessageService messageService) {
    @GetMapping("/informal-greeting")
    public String informalGreeting(Locale locale) {
        return messageService.getMessage("informal.greeting", locale);
    }
}
