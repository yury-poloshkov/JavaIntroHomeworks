import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Task01
 * Пусть дан произвольный список целых чисел.
 *   1) Нужно удалить из него чётные числа
 *   2) Найти минимальное значение
 *   3) Найти максимальное значение
 *   4) Найти среднее значение
 */
public class Task01 {

    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        int listSize = 20;
        int minValue = 10;
        int maxValue = 100;
        List<Integer> testArrayList = fillList(listSize, minValue, maxValue);
        System.out.println(testArrayList.toString());
        
        // 2) Найти минимальное значение
        int min = findElement(testArrayList, "min");        
        System.out.printf("Minimum: %d\n", min);
        
        // 3) Найти максимальное значение
        int max = findElement(testArrayList, "max");        
        System.out.printf("Maximum: %d\n", max);
        
        // 4) Найти среднее значение
        int average = findElement(testArrayList, "average");        
        System.out.printf("Average: %d\n", average);
        
        // 1) Нужно удалить из него чётные числа
        int divider = 2;
        List<Integer> devidedArrayList = removeMultiple(testArrayList, divider);
        System.out.printf("Оставшиеся элементы, после удаления всех, делящихся на %d : %s\n", divider, dividedArrayList.toString());
    }

    public static List<Integer> fillList(int size, int min, int max){
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i, ((int) (min + Math.random()*(max-min))));             
        }
        return arrayList;
    }

    public static int findElement(List<Integer> arrayList, String elementType){
        int result = 0;
        if (arrayList.size() != 0) {
            switch (elementType) {
                case "min":
                    result = Collections.min(arrayList);
                    break;
                case "max":
                    result = Collections.max(arrayList);
                    break;
                case "average":
                    int sum = 0;
                    for (int element : arrayList) {
                        sum +=element;
                    }
                    result = sum/arrayList.size();
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    public static List<Integer> removeMultiple(List<Integer> arrayList, int divider) {
        List<Integer> result = new ArrayList<>(arrayList);
        for (int i = result.size()-1; i >=0 ; i--) {
            if (result.get(i) % divider == 0){
                result.remove(i);
            }
        }
        return result;
    }
}
