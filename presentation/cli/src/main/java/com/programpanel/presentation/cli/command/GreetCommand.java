package com.programpanel.presentation.cli.command;

import com.programpanel.presentation.g11n.service.MessageService;
import java.util.Locale;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public record GreetCommand(MessageService messageService) {
    @ShellMethod("Greet me.")
    public String greet() {
        return messageService.getMessage("informal.greeting", Locale.getDefault());
    }
}
