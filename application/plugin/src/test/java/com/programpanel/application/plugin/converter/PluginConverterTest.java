package com.programpanel.application.plugin.converter;

import com.programpanel.application.plugin.dto.PluginDto;
import com.programpanel.application.plugin.dto.PluginMetadataDto;
import com.programpanel.domain.plugin.entity.Plugin;
import com.programpanel.domain.plugin.entity.PluginMetadata;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PluginConverterTest {
    @Test
    public void testThrowIfConstructorArgumentsAreNull() {
        final var e = assertThrows(NullPointerException.class, () -> new PluginConverter(null));
        assertEquals("pluginMetadataConverter cannot be null", e.getMessage());
    }

    @Test
    public void testConvertFromDto() {
        final var dto = new PluginDto(UUID.randomUUID(), new PluginMetadataDto("w", "x", "y", "z"));
        final var converter = new PluginConverter(new PluginMetadataConverter());
        final var entity = converter.convert(dto);
        assertEquals(entity.id(), dto.id());
        assertEquals(entity.metadata().name(), dto.metadata().name());
        assertEquals(entity.metadata().version(), dto.metadata().version());
        assertEquals(entity.metadata().author(), dto.metadata().author());
        assertEquals(entity.metadata().description(), dto.metadata().description());
    }

    @Test
    public void testConvertToDto() {
        final var entity = new Plugin(UUID.randomUUID(), new PluginMetadata("w", "x", "y", "z"));
        final var converter = new PluginConverter(new PluginMetadataConverter());
        final var dto = converter.convert(entity);
        assertEquals(entity.id(), dto.id());
        assertEquals(entity.metadata().name(), dto.metadata().name());
        assertEquals(entity.metadata().version(), dto.metadata().version());
        assertEquals(entity.metadata().author(), dto.metadata().author());
        assertEquals(entity.metadata().description(), dto.metadata().description());
    }
}
