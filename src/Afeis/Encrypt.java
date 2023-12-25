package Afeis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Encrypt {

    static void encrypt(FileInputStream inputStream, String password) {
        byte[] nameBytes = Util.FileName.getBytes();
        FileOutputStream outputStream = null;
        int len;
        try {
            File file = new File(new RandomName().randomName(2, 10));

            byte[] data = new byte[Util.passwordCompute(password)];
            outputStream = new FileOutputStream(file);
            outputStream.write(nameBytes.length);
            outputStream.write(nameBytes, 0, nameBytes.length);

            while ((len = inputStream.read(data)) != -1) {
                byte[] temp = Arrays.copyOf(data, len);
                Util.upsideDown(temp);
                outputStream.write(temp, 0, len);
                System.out.println(Arrays.toString(temp));
            }
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
