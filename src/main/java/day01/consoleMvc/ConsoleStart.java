package day01.consoleMvc;

import java.util.List;
import java.util.Scanner;

public class ConsoleStart {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true)
        {
            doGet();
            doPost();
        }

    }
    public static void doGet()
    {
        ConsoleController cc = new ConsoleController();
        List<ConsoleDto> res = cc.doGet();
        System.out.println("res = " + res);

    }
    public static void doPost()
    {
        System.out.println("title :");
        ConsoleController cc = new ConsoleController();
        System.out.println(cc.doPost(sc.next()));
    }
}
