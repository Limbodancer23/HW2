package HomeWork2;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import netscape.javascript.JSObject;

// Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
public class Task1 {
    public static void main(String[] args) {
        String MyLine = "{\"name\":\"Ivanov\",\"country\":\"null\",\"city\":\"Moscow\",\"age\":\"25\"}";
        String text = MyLine.substring(1, MyLine.length() - 1);
        String[] MyPair = text.split(",");
        StringBuilder sb = new StringBuilder();
        String outMessage = "select * from students WHERE ";
        sb.append(outMessage);
        boolean check = true;
        for (String i : MyPair) {
            String[] resArr = i.split(":");
            String key = resArr[0].replace("\"", "");
            String value = resArr[1].replace("\"", "");
            if(value.equals("null")){
                continue;
            }
            else{
                if (check == false){
                sb.append(" AND ");
                }
                sb.append(key).append("=").append(value);
                check = false;
            }
        }
        System.out.println(sb);

    }
}
