package com.epam.web.entities;

public enum Role {
    ADMIN("admin"), USER("user");

    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
