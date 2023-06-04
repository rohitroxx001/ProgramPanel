package com.programpanel.application.plugin.dto;

import java.util.UUID;

public record PluginDto(UUID id, PluginMetadataDto metadata) implements DataTransferObject {
    // Nothing to do.
}
