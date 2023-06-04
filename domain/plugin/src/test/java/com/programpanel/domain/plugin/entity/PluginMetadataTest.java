package com.programpanel.domain.plugin.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PluginMetadataTest {
    @ParameterizedTest
    @CsvSource({
            "name,         , x, y, z",
            "version,     w,  , y, z",
            "author,      w, x,  , z",
            "description, w, x, y,  ",
    })
    public void testThrowIfConstructorArgumentsAreNull(String field, String name, String version, String author, String description) {
        final var e = assertThrows(NullPointerException.class, () -> new PluginMetadata(name, version, author, description));
        assertEquals(field + " cannot be null", e.getMessage());
    }
}
