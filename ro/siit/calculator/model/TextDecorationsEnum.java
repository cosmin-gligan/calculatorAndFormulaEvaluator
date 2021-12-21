package ro.siit.calculator.model;

public enum TextDecorationsEnum {
    TEXT_RED("\u001B[31m"),
    TEXT_GREEN("\u001B[32m"),
    TEXT_YELLOW("\u001B[33m"),
    TEXT_BLUE("\u001B[34m"),
    TEXT_MAGENTA("\u001B[35m"),
    TEXT_CYAN("\u001B[36m"),
    TEXT_RED_BOLD("\033[1;31m"),
    TEXT_GREEN_BOLD("\033[1;32m"),
    TEXT_RESET("\u001B[0m");

    private final String value;

    private TextDecorationsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }

}
