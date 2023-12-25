package Afeis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decrypt {
    static void decrypt(FileInputStream inputStream, String password) {
        FileOutputStream outputStream = null;
        long min = Util.File.length();
        int passwordCompute = Util.passwordCompute(password);
        try {
            byte[] nameBytes = new byte[inputStream.read()];//读文件长度
            inputStream.read(nameBytes);
            Util.FileName = new String(nameBytes);//读取源文件名字
            File file = new File("afei-" + Util.FileName);
            if (min > passwordCompute) {
                min = passwordCompute;
            }
            byte[] data = new byte[(int) min - (nameBytes.length + 1)];
            outputStream = new FileOutputStream(file);
            int len;
            while ((len = inputStream.read(data)) != -1) {
                Util.upsideDown(data);
                outputStream.write(data, 0, len);
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
