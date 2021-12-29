package ro.siit.calculator;

import ro.siit.calculator.model.OperationsEnum;
import ro.siit.calculator.model.TextDecorationsEnum;
import ro.siit.calculator.services.CalculatorMethods;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws IllegalArgumentException {
        Scanner userInput = new Scanner(System.in);
        try {
            int firstNumber = 0;
            int secondNumber = 0;
            String valoareIntrodusa = "";

            System.out.println("Introduceti primul nr. intreg: ");
            valoareIntrodusa = userInput.next();
            firstNumber = CalculatorMethods.string2Number(valoareIntrodusa);


            System.out.println("Introduceti operatiunea: " + printAvailableOperations());
            String operatiune = userInput.next();

            OperationsEnum operationsEnum = CalculatorMethods.getOperation(operatiune);

            System.out.println("Introduceti al doilea nr. intreg: ");
            valoareIntrodusa = userInput.next();
            secondNumber = CalculatorMethods.string2Number(valoareIntrodusa);

            compute(firstNumber, operationsEnum, secondNumber);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            userInput.close();
        }
    }

    public static void compute(int firstNumber, OperationsEnum operation, int secondNumber) {
        int result = evaluate(firstNumber, operation, secondNumber);
        print(firstNumber, operation, secondNumber, result);

    }

    public static int evaluate(int firstNumber, OperationsEnum operation, int secondNumber) {
        int result = 0;

        switch (operation) {
            case PLUS:
                result = CalculatorMethods.addNumbers(firstNumber, secondNumber);
                break;
            case MINUS:
                result = CalculatorMethods.substractNumbers(firstNumber, secondNumber);
                break;
            case DIVIDE:
                result = CalculatorMethods.divideNumbers(firstNumber, secondNumber);
                break;
            case MULTIPLY:
                result = CalculatorMethods.multiplyNumbers(firstNumber, secondNumber);
                break;
            case REMAINDER:
                result = CalculatorMethods.remainderOfDivision(firstNumber, secondNumber);
                break;
            case POWER:
                result = CalculatorMethods.numberToThePower(firstNumber, secondNumber);
                break;
        }

//        System.out.println("calc evaluate: " + firstNumber + " " + operation.toString() + " " + secondNumber + " = " + result);

        return result;
    }
    //metoda speciala pt. formula Evaluator, avem numerele inversate din cauza stack-ului
    public static int compute4FormulaEvaluator(int secondNumber, OperationsEnum operation, int firstNumber ) throws IllegalArgumentException {
        int result = 0;

        switch (operation) {
            case PLUS:
                result = CalculatorMethods.addNumbers(firstNumber, secondNumber);
                break;
            case MINUS:
                result = CalculatorMethods.substractNumbers(firstNumber, secondNumber);
                break;
            case DIVIDE:
                result = CalculatorMethods.divideNumbers(firstNumber, secondNumber) ;
                break;
            case MULTIPLY:
                result = CalculatorMethods.multiplyNumbers(firstNumber, secondNumber );
                break;
            case REMAINDER:
                result = CalculatorMethods.remainderOfDivision(firstNumber, secondNumber);
                break;
            case POWER:
                result = CalculatorMethods.numberToThePower(firstNumber, secondNumber );
                break;
        }

        System.out.println("Formula evaluata este : " + firstNumber + " " + operation.toString() + " " + secondNumber + " = " + result);

        return result;
    }


    public static void print(Integer firstNumber, OperationsEnum op, Integer secondNumber, Integer result) {
        System.out.println(TextDecorationsEnum.TEXT_BLUE.toString() + firstNumber + " " + TextDecorationsEnum.TEXT_YELLOW + op.getVerb() + " " + TextDecorationsEnum.TEXT_MAGENTA + secondNumber + TextDecorationsEnum.TEXT_CYAN + " = " + TextDecorationsEnum.TEXT_GREEN + result + TextDecorationsEnum.TEXT_RESET);
    }

    public static String printAvailableOperations() {
        StringBuilder sb = new StringBuilder();
        String separator = "";
        for (OperationsEnum operationsEnum : OperationsEnum.values()) {
            separator = (sb.length() > 0 ? ", " : "");
            sb.append(separator + TextDecorationsEnum.TEXT_GREEN + operationsEnum.toString() + TextDecorationsEnum.TEXT_RESET);
        }
        return sb.toString();
    }
}
