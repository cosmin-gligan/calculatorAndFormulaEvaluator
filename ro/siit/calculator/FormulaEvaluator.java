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

            int result = evaluateFormula(formulaIntrodusa);
            System.out.println("Rezultatul final este: " + result);

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
            //cautam numere din formula, le completam in stack
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
            //cautam operatori in formula
            if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!operations.empty() && hasPrecedence(tokens[i], operations.peek())) {
                    numbers.push(Calculator.compute4FormulaEvaluator(numbers.pop(), CalculatorMethods.getOperation(String.valueOf(operations.pop())), numbers.pop()));
                }
                operations.push(tokens[i]);
            }
        }

        while(!operations.empty()){
            //stack-ul de numere trebuie sa aiba o marime divizibila cu 2, altfel formula este gresita
            if ( numbers.size() % 2 == 0 ) {
                numbers.push(Calculator.compute4FormulaEvaluator(numbers.pop(), CalculatorMethods.getOperation(String.valueOf(operations.pop())), numbers.pop()));
            } else {
                throw new IllegalArgumentException("\nFormula este INCORECTA: " + numbers.pop() + " " + String.valueOf(operations.pop()) + " !\nUltimul caracter din formula trebuie sa fie un NUMAR!");
            }
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
