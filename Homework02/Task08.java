/*
 * Task04
 * К калькулятору из предыдущего ДЗ добавить логирование.
 */

import java.io.FileWriter;
import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        Scanner scn = new Scanner(System.in);
        System.out.println("---- КАЛЬКУЛЯТОР v.2023.06.10 ----");
        System.out.print("Первое число: ");
        float number1 = scn.nextFloat();
        System.out.print("Операция: ");
        String operation = scn.next();
        System.out.print("Второе число: ");
        float number2 = scn.nextFloat();
        scn.close();
        System.out.println("----------------------------------");
        String result = ""+ Float.toString(number1) + " " + operation + " " + Float.toString(number2) + " = " + Calculate(operation, number1, number2);
        System.out.printf("Результат: %s", result);
        System.out.println();
        try {
            FileWriter logfile = new FileWriter("calclog.txt", true);
            logfile.append(result + "\n");
            logfile.close();    
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static String Calculate(String operation, float number1, float number2){
        String result = null;
        switch (operation) {
            case "+": 
                result = Float.toString(number1 + number2);
                break;
            case "-": 
            result = Float.toString(number1 - number2);
                break;
            case "*": 
            result = Float.toString(number1 * number2);
                break;
            case "/": 
                if (number2 != 0){
                    result = Float.toString(number1 / number2);
                }else{
                    result = "Error: ДЕЛ#0!";
                }
                break;
            default:
                result = "Error: Неподдерживаемая операция";
                break;
        }
        return result;
    } 
}
