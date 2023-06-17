package HomeWork2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// К калькулятору из предыдущего ДЗ добавить логирование.
// 3+4=7
// 1+2=3
// 6/3=2
public class Task3 {
    public static void main(String[] args) {
        Logger MyLog = Logger.getLogger(Task3.class.getName());
        MyLog.setLevel(Level.ALL);
        try {
            FileHandler fh = new FileHandler("file.txt");
            MyLog.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
        } catch (Exception e) {
            System.out.println("Error");
        }
        Scanner MyScan = new Scanner(System.in);
        Scanner MyScan1 = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = MyScan.nextInt();
        System.out.print("Choose operation(+-/*): ");
        String Oper = MyScan1.nextLine();
        System.out.print("Enter second number: ");
        int num2 = MyScan.nextInt();
        System.out.println(NewCalk(num1, Oper, num2));
        MyLog.log(Level.INFO, Integer.toString(num1));
        MyLog.log(Level.INFO, Oper);
        MyLog.log(Level.INFO, Integer.toString(num2));
        MyLog.log(Level.INFO, Integer.toString(NewCalk(num1, Oper, num2)));
        
    }

    static int NewCalk(int a, String o, int b) {
        int res = 0;
        switch (o) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "/":
                res = a / b;
                break;
            case "*":
                res = a * b;
                break;

            default:
                System.out.println("Error");
                break;
        }
        return res;
    }
}
