package Afeis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.print("请输入要加密/解密的文件名：");
            Util.FileName = scanner.next();
            Util.isHave();//判断
            System.out.print("请输入加密密码：");
            String password = scanner.next();
            System.out.print("加密或解密Y/N：");
            Util.yOrN(scanner.next().charAt(0));
            Util.input(Util.FileName, password);//输入程序
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}