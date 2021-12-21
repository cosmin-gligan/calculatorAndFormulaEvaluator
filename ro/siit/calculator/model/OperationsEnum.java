package ro.siit.calculator.model;

public enum OperationsEnum {
    PLUS("PLUS", "+", "added with"),
    MINUS("MINUS", "-", "substracted by"),
    DIVIDE("DIVIDE", "/", "divided by"),
    REMAINDER("REMAINDER", "%", "modulo of"),
    MULTIPLY("MULTIPLY", "*", "\"multiplied by"),
    POWER("POWER", "^", "to the power of");

    private final String operator;
    private final String name;
    private final String verb;


    OperationsEnum(String name, String operator, String verb) {
        this.name = name;
        this.operator = operator;
        this.verb = verb;
    }

    public String getOperator() {
        return operator;
    }

    public String getVerb() {
        return verb;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getOperator();
    }
}
