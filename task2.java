package HomeWork2;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;
import javax.sql.rowset.JoinRowSet;

// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
// 1 3 4 2
// 1 3 2 4
// 1 2 3 4
public class task2 {
    public static void main(String[] args) {
        Logger MyLog = Logger.getLogger(task2.class.getName());
        MyLog.setLevel(Level.ALL);
        try {
            FileHandler fh = new FileHandler("file.txt");
            MyLog.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
        } catch (Exception e) {
            System.out.println("Error");
        }
        int temp = 0;
        int[][] MyArr = { { 4, 3, 1, 2 }, { 4, 3, 2, 1 }, { 1, 2, 3, 4 } };
        for (int i = 0; i < MyArr.length; i++) {
            for (int j = 0; j < MyArr[i].length; j++) {
            }
            System.out.println();
        }
        for (int i = 0; i < MyArr.length; i++) {
            for (int j = 0; j < MyArr[i].length - 1; j++) {
                for (int k = 0; k < MyArr[j].length - 1; k++) {
                    MyLog.info("\n" + Arrays.toString(MyArr[0])+ "\n" + Arrays.toString(MyArr[1]) + "\n" + Arrays.toString(MyArr[2]));
                    if (MyArr[j][k] > MyArr[j][k + 1]) {
                        temp = MyArr[j][k + 1];
                        MyArr[j][k + 1] = MyArr[j][k];
                        MyArr[j][k] = temp;
                        MyLog.info("CHANGES!!!!!!!!!!!");
                    }
                }
            }
        }
        System.out.println();

        for (int i = 0; i < MyArr.length; i++) {
            for (int j = 0; j < MyArr[i].length; j++) {
                System.out.print(MyArr[i][j] + " ");
                // MyLog.info(Arrays.toString(MyArr[j]));
            }
            System.out.println();
            // MyLog.info(Arrays.toString(MyArr[i]));
        }

    }
}
