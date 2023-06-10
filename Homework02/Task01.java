import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Task01
 * Дана строка sql-запроса "select * from students WHERE ". 
 * Сформируйте часть WHERE этого запроса, используя StringBuilder. 
 * Данные для фильтрации приведены ниже в виде json-строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * Вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
 */
public class Task01 {

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