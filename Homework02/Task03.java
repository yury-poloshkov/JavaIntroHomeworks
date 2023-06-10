/*
 * Task03
 * Дана строка в файле(читать из файла) 
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * Написать метод(ы), который распарсит строчку и, 
 * используя StringBuilder, создаст строки вида: 
 * Студент [фамилия] получил [оценка] по предмету [предмет].
 * Пример вывода:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class Task03 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        String jsonString = null;
        try {
            BufferedReader freader = new BufferedReader(new FileReader("jsonstringtask01.txt")); 
            jsonString = freader.readLine();
            freader.close();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...");
        }        
        System.out.println(jsonString);
    }
}
