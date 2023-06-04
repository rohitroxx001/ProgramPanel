package com.programpanel.application.plugin.converter;

import com.programpanel.application.plugin.dto.PluginDto;
import com.programpanel.domain.plugin.entity.Plugin;
import java.util.Objects;

public record PluginConverter(PluginMetadataConverter pluginMetadataConverter) implements Converter<PluginDto, Plugin> {
    public PluginConverter {
        Objects.requireNonNull(pluginMetadataConverter, "pluginMetadataConverter cannot be null");
    }

    @Override
    public PluginDto convert(Plugin plugin) {
        final var id = plugin.id();
        final var metadata = pluginMetadataConverter.convert(plugin.metadata());
        return new PluginDto(id, metadata);
    }

    @Override
    public Plugin convert(PluginDto plugin) {
        final var id = plugin.id();
        final var metadata = pluginMetadataConverter.convert(plugin.metadata());
        return new Plugin(id, metadata);
    }
}
