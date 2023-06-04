package com.programpanel.domain.plugin.entity;

import java.util.Objects;
import java.util.UUID;

/**
 * The common interface for all plugins.
 */
public record Plugin(UUID id, PluginMetadata metadata) implements DomainEntity {
    public Plugin {
        Objects.requireNonNull(id, "id cannot be null");
        Objects.requireNonNull(metadata, "metadata cannot be null");
    }
}
