package com.programpanel.application.plugin.dto;

public record PluginMetadataDto(String name, String version, String author, String description) implements DataTransferObject {
    // Nothing to do.
}
