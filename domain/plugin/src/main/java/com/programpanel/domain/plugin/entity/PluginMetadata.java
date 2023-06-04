package com.programpanel.domain.plugin.entity;

import java.util.Objects;

/**
 * Standard information about a plugin.
 */
public record PluginMetadata(String name, String version, String author, String description) implements DomainEntity {
    public PluginMetadata {
        Objects.requireNonNull(name, "name cannot be null");
        Objects.requireNonNull(version, "version cannot be null");
        Objects.requireNonNull(author, "author cannot be null");
        Objects.requireNonNull(description, "description cannot be null");
    }
}
