/*
 * Task02
 * Реализуйте алгоритм сортировки пузырьком числового массива, 
 * результат после каждой итерации запишите в лог-файл.
 */

import java.io.FileWriter;
import java.util.Arrays;

public class Task02 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        int arraySize = 10;
        int minValue = 0;
        int maxValue = 100;
        int[] testArray = initializeIntArray(arraySize, minValue, maxValue);
        System.out.println(Arrays.toString(testArray));
        bubbleSort(testArray);
        System.out.println(Arrays.toString(testArray));
    } 

    public static int[] initializeIntArray(int size, int min, int max){
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (min + Math.random()*(max-min));             
        }
        return array;
    }

    public static void bubbleSort(int[] array){
        try {
            FileWriter logfile = new FileWriter("bubblesortlog.txt", false);
            logfile.append(Arrays.toString(array) + " - initial\n");
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length -1 - i; j++) {
                    if (array[j] > array[j + 1]){
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j+1] = temp;
                        logfile.append(Arrays.toString(array) + " - " + j + " <-> " + (j+1) + "\n");
                    }
                }
            }
            logfile.close();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...");
        }
    }
}
