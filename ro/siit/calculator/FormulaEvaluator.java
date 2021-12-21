package ro.siit.calculator;

import ro.siit.calculator.model.OperationsEnum;
import ro.siit.calculator.services.CalculatorMethods;

import java.util.*;

public class FormulaEvaluator {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        try{
            System.out.println("Introduceti o formula (de ex. 3 + 6 / 3 - 1), aplicatia va incerca sa o evalueze");

            String formulaIntrodusa = userInput.nextLine();
            //inlocuim spatiile goale
            formulaIntrodusa = formulaIntrodusa.replaceAll("\\s+","");

            System.out.println(evaluateFormula(formulaIntrodusa));

        } catch ( RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            userInput.close();
        }

    }

    public static int evaluateFormula(String formula){
        char[] tokens =  formula.toCharArray();
        Stack<Integer> numbers = new Stack<Integer>();
        Stack<Character> operations = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sb.append(tokens[i]);
                    if (i + 1 < tokens.length){
                        i++;
                    }else{
                        break;
                    }
                }
                if ( sb.length() > 0)
                    numbers.push(CalculatorMethods.string2Number(sb.toString()));
            }
            if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!operations.empty() && hasPrecedence(tokens[i], operations.peek())) {
                    numbers.push(Calculator.compute4FormulaEvaluator(numbers.pop(), CalculatorMethods.getOperation(String.valueOf(operations.pop())), numbers.pop()));
                }
                operations.push(tokens[i]);
            }
        }

        while(!operations.empty()){
            numbers.push(Calculator.compute4FormulaEvaluator(numbers.pop(), CalculatorMethods.getOperation(String.valueOf(operations.pop())), numbers.pop()));
        }

        return numbers.pop();
    }

    public static boolean hasPrecedence(char op1, char op2){
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

}
