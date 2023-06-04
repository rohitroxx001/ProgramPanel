package com.programpanel.presentation.g11n.entity;

import java.util.Objects;

public enum Iso639Language {
    EN("en", "English"),
    NO("no", "Norsk"),
    HR("hr", "Hrvatski");;

    private static final String CODE_PATTERN = "^[a-z]{2}$";
    private static final String NAME_PATTERN = "^[A-Z][a-z]+$";
    private final String code;
    private final String name;

    Iso639Language(String code, String name) {
        Objects.requireNonNull(code, "code cannot be null");
        Objects.requireNonNull(name, "name cannot be null");
        if (!code.matches(CODE_PATTERN)) {
            throw new IllegalArgumentException("code must be a two-letter lowercase ISO 639-1 language code");
        }
        if (!name.matches(NAME_PATTERN)) {
            throw new IllegalArgumentException("name must be a valid language name");
        }
        this.code = code;
        this.name = name;
    }

    public String languageCode() {
        return code;
    }

    public String languageName() {
        return name;
    }
}
