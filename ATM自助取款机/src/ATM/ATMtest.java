package ATM;

import java.util.Scanner;

public class ATMtest {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("欢迎使用XXX银行ATM取款机");
        System.out.println("即将进入界面...");
        Method.jieMian();
        Method.menu();
    }

}
