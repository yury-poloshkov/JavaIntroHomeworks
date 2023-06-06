import java.util.Scanner;

/**
 * Task01
 * Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */
public class Task01 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        System.out.print("Введите натуральное число N: ");
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        System.out.printf("%d-ое треугольное число = %d", number, triangle(number));
        System.out.println();
        System.out.printf("%d! = %d", number, factorial(number));
        System.out.println();
        scn.close();
    }
    
    public static int triangle (int number) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            result += i;
        }
        return result;
    }
    public static long factorial (int number) {
        if (number < 2) return 1;
        return number * factorial(number - 1);
    }
}