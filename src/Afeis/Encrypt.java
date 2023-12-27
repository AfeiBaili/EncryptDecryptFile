package Afeis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Encrypt {

    static void encrypt(FileInputStream inputStream, String password) {
        byte[] nameBytes = Util.fileName.getBytes();
        FileOutputStream outputStream = null;
        int len;
        try {
            File file = new File(new RandomName().randomName(2, 10) + ".afei");
            byte[] data = new byte[Util.passwordCompute(password)];
            outputStream = new FileOutputStream(file);
            outputStream.write(nameBytes.length);
            outputStream.write(nameBytes, 0, nameBytes.length);
            Util.byteLength = Util.file.length();//总共字节长度
            while ((len = inputStream.read(data)) != -1) {
                byte[] temp = Arrays.copyOf(data, len);
                Util.currentByteLength += temp.length;
                Util.upsideDown(temp);
                outputStream.write(temp, 0, len);
                Util.progressBarPrint();
            }
            System.out.println("：加密成功");
            //End
        } catch (IOException e) {
            System.out.println("读取写出异常");
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("加密关闭异常");
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("加密关闭异常");
            }
        }
    }
}
