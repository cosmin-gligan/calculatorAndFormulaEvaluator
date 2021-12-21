package ro.siit.calculator.services;

import ro.siit.calculator.model.OperationsEnum;
import ro.siit.calculator.model.TextDecorationsEnum;

public class CalculatorMethods {

    public static int string2Number(String number) throws IllegalArgumentException{
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TextDecorationsEnum.TEXT_RED_BOLD + "Numar incorect!" + TextDecorationsEnum.TEXT_RESET);
        }
    }
    public static boolean checkIsNumber(String number) {
        if (number.matches("[0-9]+"))
            return true;
        else {
            System.out.println(TextDecorationsEnum.TEXT_RED_BOLD + number + " nu este de tip INTEGER" + TextDecorationsEnum.TEXT_RESET);
            return false;
        }
    }

    public static OperationsEnum getOperation(String operation) throws IllegalArgumentException {
        boolean isCorrect = false;
        for (OperationsEnum opEnum : OperationsEnum.values()) {
            if (opEnum.getOperator().equals(operation) || opEnum.toString().equals(operation)) {
                return opEnum;
            }
        }
        if (!isCorrect) {
            throw new IllegalArgumentException(TextDecorationsEnum.TEXT_RED_BOLD + "Operatiune incorecta!" + TextDecorationsEnum.TEXT_RESET);
        }
        //nu o sa ajunga niciodata aici
        return OperationsEnum.PLUS;
    }

    public static int addNumbers(int pNumber1, int pNumber2) {
        return pNumber1 + pNumber2;
    }

    public static int substractNumbers(int pNumber1, int pNumber2) {
        return pNumber1 - pNumber2;
    }

    public static int divideNumbers(int pNumber1, int pNumber2) throws IllegalArgumentException {
        if (pNumber2 == 0)
            throw new IllegalArgumentException(TextDecorationsEnum.TEXT_RED_BOLD + "Numarul la care se imparte NU poate fi ZERO!" + TextDecorationsEnum.TEXT_RESET);
        return pNumber1 / pNumber2;
    }

    public static int multiplyNumbers(int pNumber1, int pNumber2) {
        return pNumber1 * pNumber2;
    }

    public static int remainderOfDivision(int pNumber1, int pNumber2) {
        return pNumber1 % pNumber2;
    }

    public static int numberToThePower(int pNumber1, int pNumber2) {
        Double result = Math.pow(pNumber1, pNumber2);
        return result.intValue();
    }


}
