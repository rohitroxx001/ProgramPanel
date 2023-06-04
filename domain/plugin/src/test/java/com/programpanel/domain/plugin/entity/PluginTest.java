package com.programpanel.domain.plugin.entity;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PluginTest {
    @Test
    public void testThrowIfConstructorArgumentsAreNull() {
        final var id = UUID.randomUUID();
        final var metadata = new PluginMetadata("w", "x", "y", "z");
        assertEquals("id cannot be null", assertThrows(NullPointerException.class, () -> new Plugin(null, metadata)).getMessage());
        assertEquals("metadata cannot be null", assertThrows(NullPointerException.class, () -> new Plugin(id, null)).getMessage());
    }
}
