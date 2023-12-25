import java.io.*;

public class Encrypt {

    static void encrypt(FileInputStream inputStream, String password) {
        byte[] nameBytes = Util.FileName.getBytes();
        FileOutputStream outputStream = null;
        int len;
        int passwordCompute = Util.passwordCompute(password);
        try {
            File file = new File(new RandomName().randomName(2, 10) + ".txt");
            long min = Util.File.length();
            if (min > passwordCompute) {
                min = passwordCompute;
            }
            byte[] data = new byte[(int) min];
            outputStream = new FileOutputStream(file);
            outputStream.write(nameBytes.length);
            outputStream.write(nameBytes, 0, nameBytes.length);

            while ((len = inputStream.read(data)) != -1) {
                Util.upsideDown(data);
                outputStream.write(data, 0, len);
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
