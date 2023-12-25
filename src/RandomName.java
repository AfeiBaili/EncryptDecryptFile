import java.util.Random;

public class RandomName {
    private static final char[] LETTER = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static String name = "";
    private final Random random = new Random();

    public String randomName(int xms, int xmx) {
        if (xms > xmx) {
            int temp = xms;
            xms = xmx;
            xmx = temp;
        }
        xmx++;
        for (int i = 0; i < random.nextInt(xms, xmx); i++) {
            int anNum = random.nextInt(26);
            name += i == 0 ? String.valueOf(LETTER[anNum]).toUpperCase() : String.valueOf(LETTER[anNum]);
        }
        String tempString = name;
        name = "";
        return tempString;
    }
}
