import java.io.File;

public class Util {
    //颠倒数组
    public static byte[] upsideDown(byte[] bytes) {
        for (int start = 0, end = bytes.length; start <= end >> 1; start++, end--) {
            byte temp = bytes[start];
            bytes[start] = bytes[end - 1];
            bytes[end - 1] = temp;
        }
        return bytes;
    }

    //判断文件是否存在
    public static void isHave() {
        File fileAll = new File(System.getProperty("user.dir"));
        File[] files = fileAll.listFiles();
        boolean have = true;
        if (files != null)
            for (File file : files) {
                if (file.getName().equals(Encrypt.FileName)) {
                    have = false;
                    break;
                }
            }
        if (have)
            throw new RuntimeException("找不到文件");
    }

    public static void yOrN(char c) {
        switch (c) {
            case 'y', 'Y':
                return;
            case 'n', 'N':
                Encrypt.isEncrypt = false;
                return;
            default:
                throw new RuntimeException("输入错误！");
        }
    }
}
