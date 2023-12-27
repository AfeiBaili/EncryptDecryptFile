package Afeis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Util {
    static String fileName = "";
    static File file;
    static boolean isEncrypt = true;
    static long byteLength = 0;
    static long currentByteLength = 0;

    static void input(String fileName, String password) {
        Util.fileName = fileName;
        //读取模块
        Util.file = new File(Util.fileName);//读取文件
        FileInputStream inputStream = null;//设置输入流
        try {
            if (isEncrypt) {
                Encrypt.encrypt(inputStream = new FileInputStream(Util.file), password);//调用加密方法
            } else {
                Decrypt.decrypt(inputStream = new FileInputStream(Util.file), password);//调用解密方法
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("关闭异常");
            }
        }
    }

    //颠倒数组
    static byte[] upsideDown(byte[] bytes) {
        for (int start = 0, end = bytes.length; start <= end >> 1; start++, end--) {
            byte temp = bytes[start];
            bytes[start] = bytes[end - 1];
            bytes[end - 1] = temp;
        }
        return bytes;
    }

    //判断文件是否存在
    static void isHave() {
        File fileAll = new File(System.getProperty("user.dir"));
        File[] files = fileAll.listFiles();
        boolean have = true;
        if (files != null)
            for (File file : files) {
                if (file.getName().equalsIgnoreCase(Util.fileName)) {
                    have = false;
                    break;
                }
            }
        if (have)
            throw new Afeis.FileNotFoundException("找不到文件");
    }

    //Yes或No
    static void yOrN(char c) {
        switch (c) {
            case 'y', 'Y':
                return;
            case 'n', 'N':
                Util.isEncrypt = false;
                return;
            default:
                throw new RuntimeException("输入错误！");
        }
    }

    //密码计算
    static int passwordCompute(String password) {
        int sum = password.hashCode();
        while (true) {
            if (sum > 1024 * 20) {
                sum = sum >> 1;
            } else {
                break;
            }
        }
        return sum;
    }

    static void progressBarPrint() {
        ProgressBar.percentage = (float) currentByteLength / byteLength * 100;
        ProgressBar.printProgress();
    }
}