import java.util.Scanner;

/**
 * Task04
 * (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. 
 * Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
 * Требуется восстановить выражение до верного равенства. 
 * Предложить хотя бы одно решение или сообщить, что его нет.
 * Под знаком вопроса - всегда одинаковая ЦИФРА.
 * Введите уравнение: ?? + ?? = 44
 * Решение: 22 + 22 = 44
 */
public class Task04 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String task = scn.next();
        scn.close();
        System.out.println("Восстановленное выражение: " + Rebuild(task));
    }
    public static String Rebuild(String task){
        int[][] numbers = new int[3][2];
        numbers = DecompileTask(task);
        int delta = numbers[2][0] - (numbers[0][0] + numbers[1][0]); 
        String decision = "Решение не найдено...";
        for (int i = 0; i < 10; i++){
            if ((numbers[0][1] + numbers[1][1]) * i == delta){
                decision = (numbers[0][0] + numbers[0][1] * i) + " + " + (numbers[1][0] + numbers[1][1] * i) + " = " + numbers[2][0]; 
            };
        }
        return decision;
    }
    public static int[][] DecompileTask(String task){
        int[][] numbers = new int[3][2];
        int curRow = 0; 
        for (int i = 0; i < task.length(); i++) {
            switch (task.charAt(i)) {
                case '0', '1', '2', '3', '4','5','6','7','8','9':
                    numbers[curRow][0] = numbers[curRow][0]* 10 + Character.digit(task.charAt(i),10);
                    numbers[curRow][1] = numbers[curRow][1]* 10;
                    break;
                case '?':
                    numbers[curRow][1] = numbers[curRow][1]* 10 + 1;
                    numbers[curRow][0] = numbers[curRow][0]* 10;
                    break;
                case '+', '=':
                    curRow++;
                    break;
                default:
                    break;
            }
        }
        //Print2DIntArray(numbers);
        return numbers;
    }
    public static void Print2DIntArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                System.out.print(array[i][j] + "\t");               
            }
            System.out.println();
        }
    }
}