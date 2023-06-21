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

public class Task07 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        String jsonString = null;
        String outputMask = "Студент [фамилия] получил [оценка] по предмету [предмет].";
        try {
            BufferedReader freader = new BufferedReader(new FileReader("jsonstringtask03.txt")); 
            jsonString = freader.readLine();
            while (jsonString != null){
                String[] jsonArray = splitToArray(jsonString);
                for (String jsonElement : jsonArray) {
                    System.out.println(compileRecord(jsonElement, outputMask));                
                }
                jsonString = freader.readLine();
            }
            freader.close();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...");
        }
    }      
    
    private static String compileRecord(String jsonElement, String outputMask) {
        StringBuilder result = new StringBuilder(outputMask);
        String[] fields = jsonElement.split(",");
        for (String line : fields) {
            String[] field = line.split(":");
            int replacePosition = result.lastIndexOf("[" + field[0] + "]");
            result.replace(replacePosition, replacePosition + field[0].length() + 2, field[1]);
            }
        return result.toString();
    }

    private static String[] splitToArray(String jsonString) {
        jsonString = jsonString.replace("\"", "");
        jsonString = jsonString.replace("[{", "");
        jsonString = jsonString.replace("}]", "");
        jsonString = jsonString.replace("},{", ";");
        String[] array = jsonString.split(";");
        return array;
    }
}
