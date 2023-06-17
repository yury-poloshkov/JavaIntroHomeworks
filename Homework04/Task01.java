package Homework04;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * task01
 * Даны два Deque, представляющие два целых числа. 
 * Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
 * 1) Умножьте два числа и верните произведение в виде связанного списка.
 * 2) Сложите два числа и верните сумму в виде связанного списка.
 * Одно или два числа могут быть отрицательными.
 */
public class Task01 {
    public static void main(String[] args) {
        int minSize = 2;
        int maxSize = 7;
        int minValue = 0;
        int maxValue = 10;  
        Deque<String> number1 = fillDeque(minSize, maxSize, minValue, maxValue);
        System.out.print(number1);
        Deque<String> number2 = fillDeque(minSize, maxSize, minValue, maxValue);
        System.out.println(number2);
        String operation = "*";
        List<String> result = calcN1withN2(number1, number2, operation);
        System.out.println(result);
    }

    public static List<String> calcN1withN2(Deque<String> number1, Deque<String> number2, String operation) {
        List<String> result = new LinkedList<>();
        int num1 = dequeToInt(number1);
        int num2 = dequeToInt(number2);
        long res = 0;
        switch (operation) {
            case "*":
                res = num1 * num2;        
                break;
            case "+":
                res = num1 + num2;
                break;
            default:
                return null;
                //break;
        }
        System.out.printf("%d %s %d = %d \n", num1,operation, num2, res);
        String sign = null;
        if (res < 0){
            sign = "-";
            res *= -1;
        }
        while (res != 0){
            result.add(0, "" + res % 10);
            res /= 10;
        }
        if (sign != null){
            result.add(0, sign);
        }
        return result;
    }

    public static int dequeToInt(Deque<String> number) {
        int sign = 1;
        if (number.peekLast().equals("-")){
            sign = -1;
            number.removeLast();
        }
        int size = 0;
        int result = 0;
        while (!number.isEmpty()){
            result += Integer.parseInt(number.poll()) * (int) Math.pow(10, size);
            size++;
        }
        return result * sign;
    }

    private static Deque<String> fillDeque(int minSize, int maxSize, int minValue, int maxValue) {
        Deque<String> result = new LinkedList<>();
        int size = (int) (minSize +  Math.random()*(maxSize - minSize));
            for (int i = 0; i < size; i++) {
                result.add(""+(int) (minValue + Math.random()*(maxValue - minSize)));
            }
            if (Math.random()>0.5) result.add("-");
        return result;
    }
}