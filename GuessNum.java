package mastermind;

import java.util.function.Supplier;
import java.util.Scanner;

public class GuessNum {
    static Scanner input = new Scanner(System.in);
    static BaseData baseData = new BaseData();
    static ErrorHandler errHandle = new ErrorHandler();

    public static void main(String[] args) {
        String yesNo = "";

        outerLoop: while (true) {
            while (true) {
                printMessage(() -> "Computer V.S Player (y/n) ? ");

                yesNo = input.nextLine();

                errHandle.chkYesNoError(yesNo);

                if (errHandle.getError()) {
                    printMessage(() -> errHandle.getErrMsg());
                } else {
                    break;
                }
            }

            switch (Choose.valueOf(yesNo.toUpperCase())) {
                case Y:
                    computer();
                    break;
                case N:
                    player01();
                    break;
            }

            start();

            String result = player2();
            switch (Choose.valueOf(result.toUpperCase())) {
                case Y:
                    break;
                case N:
                    printMessage(() -> "Bye Bye~~~");
                    break outerLoop;
            }
        }
    }

    private static void start() {
        for (int i = 0; i < 60; i++) {
            System.out.println();
        }

        // System.out.println("Ans:" + baseData.getCorrectAns());
        printMessage(() -> "--- Player2 Start to guess ---");
        printMessage(() -> "Type '0' to give up the game.");
        baseData.setGuessTimes(1);
    }

    public static String endGameMessage(String msg) {
        printMessage(() -> msg);
        String contin = "N";

        while (true) {
            printMessage(() -> "Do you want to Continue (y/n)?");
            contin = input.nextLine();
            errHandle.chkYesNoError(contin);

            if (errHandle.getError()) {
                System.out.println(errHandle.getErrMsg());
            } else {
                break;
            }
        }

        return contin;
    }

    private static String hints(String guess) {
        int countBlack = 0;
        int countWhite = 0;
        String correctAns = baseData.getCorrectAns();

        baseData.setWhite(0);
        baseData.setBlack(0);

        for (int i = 0; i < baseData.getMaxColourNum(); i++) {
            if (guess.charAt(i) == correctAns.charAt(i)) {
                correctAns = correctAns.substring(0, i) + "B" + correctAns.substring(i + 1);
                baseData.setBlack(++countBlack);
            }
        }

        for (int i = 0; i < baseData.getMaxColourNum(); i++) {
            for (int j = 0; j < baseData.getMaxColourNum(); j++) {
                if (guess.charAt(i) == correctAns.charAt(j)) {
                    baseData.setWhite(++countWhite);
                    correctAns = correctAns.substring(0, j) + "W" + correctAns.substring(j + 1);
                }
            }
        }
        
        return "Black: " + baseData.getBlack() + "   " + "White: " + baseData.getWhite();
    }

    public static Boolean validaGuessInput(String input) {
        errHandle.chkPegsColour(input, baseData);
        Boolean err01 = errHandle.getError();
        if (err01) {
            printMessage(() -> errHandle.getErrMsg());
        }

        errHandle.chkPegsNumber(input, baseData);
        Boolean err02 = errHandle.getError();
        if (err02) {
            printMessage(() -> errHandle.getErrMsg());
        }

        return err01 || err02;
    }

    public static void computer() {
        String ans = "";

        for (int i = 0; i < baseData.getMaxColourNum(); i++) {
            int ansEle = (int) (Math.random() * (baseData.getMaxColourValue() - baseData.getMinColourValue() + 1)
                    + baseData.getMinColourValue());

            ans += String.valueOf(ansEle);
        }

        baseData.setCorrectAns(ans);
    }

    public static void player01() {
        printMessage(() -> "Player1 input the answer: ");
        String playerAnsInput = input.nextLine();

        while (true) {
            Boolean err = validaGuessInput(playerAnsInput);

            if (err) {
                printMessage(() -> "Player1 input the answer: ");
                playerAnsInput = input.nextLine();
            } else {
                break;
            }
        }

        baseData.setCorrectAns(String.valueOf(playerAnsInput));
    }

    public static String player2() {
        String guess = "";
        Boolean win = false;

        while (true) {
            int guesTimes = baseData.getGuessTimes();
            int maxGuesTimes = baseData.getMaxGuesstimes();

            System.out.println("Step" + guesTimes + ": Please input your guess: ");
            guess = input.nextLine();

            char[] giveUp = guess.toCharArray();

            if (guess.length() == 1 && giveUp[0] == '0') {
                break;
                // System.exit(1);
            }

            Boolean err = validaGuessInput(guess);
            if (err) {
                continue;
            }

            System.out.println("Guess " + guesTimes + ": " + guess + "\t" + hints(guess));

            if (baseData.getBlack() == baseData.getMaxColourNum()) {
                win = true;
                break;
            }

            if (guesTimes >= maxGuesTimes) {
                break;
            }

            baseData.setGuessTimes(guesTimes + 1);
        }

        String endGameMsg = !win ? "You Lose!! Correct Answer is " + baseData.getCorrectAns() : "You Win!!!";

        return endGameMessage(endGameMsg);
    }

    public static void printMessage(Supplier<?> supplier) {
        System.out.println(supplier.get());
    }
}