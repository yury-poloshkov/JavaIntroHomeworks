/**
 * Task02
 * Вывести все простые числа от 1 до 1000
 */
public class Task02 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        int target = 1000;
        int columns = 0;
        for (int i = 2; i <= target; i++) {
            if (IsSimple(i)) {
                System.out.print(i + "\t");
                columns++;
                if (columns % 10 == 0) System.out.println();
            }
        }
        System.out.println();
    }
    public static boolean IsSimple(int number) {
        boolean flag = true;
        int curNumber = 2;
        while (flag == true && (curNumber <= Math.sqrt(number))){
            if (number %  curNumber == 0 ) flag = false;
            curNumber++;
        }
        return flag;
    }
    
}
