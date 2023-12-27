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
            Util.currentByteLength += nameBytes.length + 1;
            inputStream.read(nameBytes);
            Util.fileName = new String(nameBytes);//读取源文件名字
            File file = new File(Util.fileName);
            byte[] data = new byte[Util.passwordCompute(password)];
            outputStream = new FileOutputStream(file);
            int len;
            Util.byteLength = Util.file.length();//总共字节长度
            while ((len = inputStream.read(data)) != -1) {
                byte[] temp = Arrays.copyOf(data, len);
                Util.currentByteLength += temp.length;
                Util.upsideDown(temp);
                outputStream.write(temp, 0, len);
                Util.progressBarPrint();
            }
            System.out.println("：解密成功");
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
