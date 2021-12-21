package ro.siit.calculator.model;

public enum OperationsEnum {
    PLUS("PLUS", "+", "added with", 2),
    MINUS("MINUS", "-", "substracted by", 2),
    DIVIDE("DIVIDE", "/", "divided by", 1),
    REMAINDER("REMAINDER", "%", "modulo of", 1),
    MULTIPLY("MULTIPLY", "*", "\"multiplied by", 1),
    POWER("POWER", "^", "to the power of", 1);

    private final String operator;
    private final String name;
    private final String verb;
    private final int priority;


    OperationsEnum(String name, String operator, String verb, int priority) {
        this.name = name;
        this.operator = operator;
        this.verb = verb;
        this.priority = priority;
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

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return getOperator();
    }
}
