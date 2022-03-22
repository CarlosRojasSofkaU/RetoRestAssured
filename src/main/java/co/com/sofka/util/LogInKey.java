package co.com.sofka.util;

public enum LogInKey {
    EMAIL("[email]"),
    PASSWORD("[password]");

    private final String value;

    LogInKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
