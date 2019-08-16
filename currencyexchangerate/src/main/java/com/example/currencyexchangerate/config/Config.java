package com.example.currencyexchangerate.config;

public enum Config {
    SERVER_URL("http://www.dongabank.com.vn/exchange/export");

    Config(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
