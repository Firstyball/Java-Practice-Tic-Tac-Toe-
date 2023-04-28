import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String X = "X";
        String O = "○";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("do you want to continue?");
            if (scanner.nextLine().equals("yes")) {
                String[] top = {"0", "1", "2"};
                String[] mid = {"0", "1", "2"};
                String[] bottom = {"0", "1", "2"};

                boolean win = false;
                boolean xPlay = true;
                generateField(top, mid, bottom);

                while (!win) {
                    if (xPlay) {

                        gameLoop(top, mid, bottom, X, scanner);
                        win = winTest(top, mid, bottom);
                        xPlay = false;
                    } else {

                        gameLoop(top, mid, bottom, O, scanner);
                        win = winTest(top, mid, bottom);
                        xPlay = true;
                    }
                    if (win) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }

    private static void gameLoop(String[] top, String[] mid, String[] bottom, String X, Scanner scanner) {
        System.out.println("Player: " + X);
        System.out.println("Put TOP, MID or BOT for change the column");
        String input = scanner.nextLine().toUpperCase();
        System.out.println("Put 0, 1, 2 for change to x");
        String inputNumber = scanner.nextLine().toUpperCase();

        switch (input) {
            case ("TOP") -> changeNumberTop(top, mid, bottom, inputNumber, X);
            case ("MID") -> changeNumberMid(top, mid, bottom, inputNumber, X);
            case ("BOT") -> changeNumberBot(top, mid, bottom, inputNumber, X);
        }
    }

    public static boolean winTest(String[] top, String[] mid, String[] bottom) {

        boolean winCondition = false;

        String w1, w2, w3, w4, w5, w6, w7, w8;

        w1 = top[0] + top[1] + top[2];
        w2 = mid[0] + mid[1] + mid[2];
        w3 = bottom[0] + bottom[1] + bottom[2];
        w4 = top[0] + mid[0] + bottom[0];
        w5 = top[1] + mid[1] + bottom[1];
        w6 = top[2] + mid[2] + bottom[2];
        w7 = top[0] + mid[1] + bottom[2];
        w8 = top[2] + mid[1] + bottom[0];

        String[] winXXX = {w1, w2, w3, w4, w5, w6, w7, w8};
        //win X
        for (int i = 0; i < 8; i++) {
            if (winXXX[i].equals("XXX")) {
                winCondition = true;
                System.out.println("X WIN XXX");
                System.out.println("X WIN XXX");
            }
        }
        //win ○
        for (int i = 0; i < 8; i++) {
            if (winXXX[i].equals("○○○")) {
                winCondition = true;
                System.out.println("○ WIN ○○○");
                System.out.println("○ WIN ○○○");
            }
        }
        return winCondition;
    }

    private static void changeNumberTop(String[] top, String[] mid, String[] bottom, String inputNumber, String player) {
        switch (inputNumber) {
            case ("0") -> {
                top[0] = player;
                generateField(top, mid, bottom);
            }
            case ("1") -> {
                top[1] = player;
                generateField(top, mid, bottom);
            }
            case ("2") -> {
                top[2] = player;
                generateField(top, mid, bottom);
            }
        }
    }

    private static void changeNumberMid(String[] top, String[] mid, String[] bottom, String inputNumber, String player) {
        switch (inputNumber) {
            case ("0") -> {
                mid[0] = player;
                generateField(top, mid, bottom);
            }
            case ("1") -> {
                mid[1] = player;
                generateField(top, mid, bottom);
            }
            case ("2") -> {
                mid[2] = player;
                generateField(top, mid, bottom);
            }
        }
    }

    private static void changeNumberBot(String[] top, String[] mid, String[] bottom, String inputNumber, String player) {
        switch (inputNumber) {
            case ("0") -> {
                bottom[0] = player;
                generateField(top, mid, bottom);
            }
            case ("1") -> {
                bottom[1] = player;
                generateField(top, mid, bottom);
            }
            case ("2") -> {
                bottom[2] = player;
                generateField(top, mid, bottom);
            }
        }
    }

    private static void generateField(String[] top, String[] mid, String[] bottom) {
        for (int i = 0; i < 1; i++) {
            System.out.println("-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-----");
            System.out.println("TOP" + " |" + " " + top[0] + " | " + top[1] + " | " + top[2] + " |");
            System.out.println("MID" + " |" + " " + mid[0] + " | " + mid[1] + " | " + mid[2] + " |");
            System.out.println("BOT" + " |" + " " + bottom[0] + " | " + bottom[1] + " | " + bottom[2] + " |");
            System.out.println("-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-" + "-----");
        }
    }
}