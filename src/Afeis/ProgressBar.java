package Afeis;

public class ProgressBar {
    static StringBuilder progress = new StringBuilder();
    static StringBuilder idleProgress = new StringBuilder();
    static StringBuilder backslashB = new StringBuilder();

    static int length = 100;
    static float percentage = 0;
    static int intPercentage = 0;

    static {
        idleProgress.append("-".repeat(length + 1));
    }


    static void printProgress() {
        if ((int) percentage == intPercentage) {
            intPercentage++;
            printProgressBar();
        }
    }

    static void printProgressBar() {
        if ((int) percentage != 0) {
            System.out.print(backslashB());
        }
        System.out.print(progress() + (int) percentage + "%");
    }

    static String progress() {
        String string = "进度->[";
        return string + usedProgress() + availableProgress() + ']';
    }

    static StringBuilder usedProgress() {
        return progress.append("#");
    }

    static StringBuilder availableProgress() {
        return idleProgress.deleteCharAt(idleProgress.length() - 1);
    }

    static StringBuilder backslashB() {
        for (int i = backslashB.length(); i < length + String.valueOf(percentage).length() + 7; i++) {
            backslashB.append("\b");
        }
        return backslashB;
    }
}
