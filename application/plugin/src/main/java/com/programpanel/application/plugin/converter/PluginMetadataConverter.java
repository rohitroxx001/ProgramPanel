package com.programpanel.application.plugin.converter;

import com.programpanel.application.plugin.dto.PluginMetadataDto;
import com.programpanel.domain.plugin.entity.PluginMetadata;

public record PluginMetadataConverter() implements Converter<PluginMetadataDto, PluginMetadata> {
    @Override
    public PluginMetadataDto convert(PluginMetadata pluginMetadata) {
        final var name = pluginMetadata.name();
        final var version = pluginMetadata.version();
        final var author = pluginMetadata.author();
        final var description = pluginMetadata.description();
        return new PluginMetadataDto(name, version, author, description);
    }

    @Override
    public PluginMetadata convert(PluginMetadataDto pluginMetadata) {
        final var name = pluginMetadata.name();
        final var version = pluginMetadata.version();
        final var author = pluginMetadata.author();
        final var description = pluginMetadata.description();
        return new PluginMetadata(name, version, author, description);
    }
}
