package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProxyType {
    MSISDN("MSISDN"), EMAIL("EMAIL"), UNKNOWN("UNKNOWN");

    private String value;

    ProxyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ProxyType fromValue(String text) {
        for (ProxyType b : ProxyType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }
}
