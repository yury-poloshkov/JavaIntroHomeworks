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

public class Task05 {

    public static void main(String[] args) {
        System.out.print("\033[H\033[J");
        String jsonString = null;
        try {
            BufferedReader freader = new BufferedReader(new FileReader("jsonstringtask01.txt")); 
            jsonString = freader.readLine();
            while (jsonString != null){
                String sqlRequest = "select * from students" + requestBuilder(jsonString);
                System.out.println(sqlRequest);
                jsonString = freader.readLine();    
            }
            freader.close();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...");
        }        
    }
    public static String requestBuilder (String jsonString){
        StringBuilder request = new StringBuilder(jsonString);
        String operator = " AND ";
        String eliminateItem = "\"null\"";
        for (int i = 0; i < request.length(); i++) {
            switch (request.charAt(i)) {
                case '{', '}', '"', ' ':
                    request.deleteCharAt(i);
                    i--;
                    break;
                case ',':
                    request.deleteCharAt(i); 
                    if (i != 0){
                        request.insert(i, operator);
                        i += operator.length();
                    }
                    i--;
                    break;
                case ':':
                    request.setCharAt(i, '=');
                    if (request.length() > i + eliminateItem.length() && request.substring(i + 1 , i + eliminateItem.length() + 1).equals(eliminateItem)){
                        int lastOperatorIndex = request.substring(0,i).lastIndexOf(operator);
                        lastOperatorIndex = lastOperatorIndex < 0 ? 0 : lastOperatorIndex;
                        request.delete(lastOperatorIndex, i + eliminateItem.length());
                        i = lastOperatorIndex - 1;
                    }
                    break;
            }
        }
        if (request.length() != 0){
            request.insert(0, " WHERE ");
        } 
        return request.toString();
    }
}