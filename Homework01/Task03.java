import java.util.Scanner;

/**
 * Task03
 * Реализовать простой калькулятор (+-/*)
 */
public class Task03 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        Scanner scn = new Scanner(System.in);
        System.out.println("---- КАЛЬКУЛЯТОР v.2023.06.06 ----");
        System.out.print("Первое число: ");
        float number1 = scn.nextFloat();
        System.out.print("Операция: ");
        String operation = scn.next();
        System.out.print("Второе число: ");
        float number2 = scn.nextFloat();
        System.out.println("----------------------------------");
        System.out.printf("Результат: %s %s %s = %s", 
        Float.toString(number1), operation, Float.toString(number2), Calculate(operation, number1, number2));
        System.out.println();
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