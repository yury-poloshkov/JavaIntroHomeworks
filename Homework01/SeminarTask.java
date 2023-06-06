import java.util.Arrays;

/**
 * SeminarTask
 */
public class SeminarTask {

    public static void main(String[] args) {
        /*
        Дан массив nums = [3,2,4,3,3,1,5,3,3] и число val = 3. 
        Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива. 
        Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, 
        а остальные - равны ему.
        */

        int[] numbers = new int[] {1,2,4,3,3,3,5,3,3,1,1};
        int val = 3;
        int chain = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != val) {
                if (chain != 0) {
                    numbers[i-chain] = numbers[i];
                    numbers[i] = val;
                }
            }else {
                chain++;
            }
        }
        System.out.println(Arrays.toString(numbers));

    }
}
