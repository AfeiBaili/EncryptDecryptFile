package Afeis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Decrypt {
    static void decrypt(FileInputStream inputStream, String password) {
        FileOutputStream outputStream = null;
        try {
            byte[] nameBytes = new byte[inputStream.read()];//读文件长度
            inputStream.read(nameBytes);
            Util.FileName = new String(nameBytes);//读取源文件名字
            File file = new File("afei-" + Util.FileName);
            byte[] data = new byte[Util.passwordCompute(password)];
            outputStream = new FileOutputStream(file);
            int len;
            while ((len = inputStream.read(data)) != -1) {
                byte[] temp = Arrays.copyOf(data, len);
                Util.upsideDown(temp);
                outputStream.write(temp, 0, len);
                System.out.println(Arrays.toString(temp));
            }
        } catch (IOException e) {
            System.out.println("读取异常");
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("解密关闭异常");
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("解密关闭异常");
            }
        }
    }
}
