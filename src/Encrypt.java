import java.io.*;

public class Encrypt {
    static String FileName = "";

    public static void input(String fileName, String password) {
        FileName = fileName;
        //读取模块
        File file = new File(FileName);//读取文件
        FileInputStream inputStream = null;//设置输入流
        try {
            encrypt(inputStream = new FileInputStream(file), password);//调用加密方法

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

    public static void encrypt(FileInputStream inputStream, String password) {
        byte[] passwordBytes = password.getBytes();//转化为字节
        byte[] data = new byte[1023];
        FileOutputStream outputStream = null;
        try {
            int len;
            outputStream = new FileOutputStream(new RandomName().randomName(3, 10));
            while ((len = inputStream.read(data)) != -1) {
                byte[] upsideDownData = Util.upsideDown(data);
                outputStream.write(upsideDownData, 0, len);
            }
            outputStream.write(Util.upsideDown(passwordBytes));
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
                System.out.println("关闭异常");
            }
        }
    }


}