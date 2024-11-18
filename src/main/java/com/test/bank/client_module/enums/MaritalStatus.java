package com.test.bank.client_module.enums;

public enum MaritalStatus {
    single("single"),
    married("married");

    private final String value;

    MaritalStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
