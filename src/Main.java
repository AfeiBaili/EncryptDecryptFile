import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.print("请输入要加密/解密的文件名：");
            Encrypt.FileName = scanner.next();
            System.out.println();
            Util.isHave();//判断
            System.out.print("请输入加密密码：");
            String password = scanner.next();
            System.out.println();
            System.out.println("加密还是解密Y/N：");
            Util.yOrN(scanner.next().charAt(0));
            Encrypt.input(Encrypt.FileName, password);//加密
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}