package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void readCharacter() {
        try {
            do {
                interpreter.calu = (char) reader.read();
            } while (interpreter.calu == ' ' || interpreter.calu == '\n' || interpreter.calu == '\t');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int clearBuffer() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char temp;
        int retour = 0;
        try {
            do {
                temp = (char) reader.read();
                if (temp != ' ' && temp != '\t' && temp != '\n') {
                    retour = -1;
                }
            } while (temp != '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retour;
    }

    public static char recognizeDigit() {
        return (interpreter.calu >= '0' && interpreter.calu <= '9') ? interpreter.calu : 0;
    }

    public static char recognizeDot() {
        return (interpreter.calu == '.') ? interpreter.calu : 0;
    }

    public static char recognizeAdditiveOperator() {
        return (interpreter.calu == '+' || interpreter.calu == '-') ? interpreter.calu : 0;
    }

    public static char recognizeMultiplicativeOperator() {
        return (interpreter.calu == '*' || interpreter.calu == '/') ? interpreter.calu : 0;
    }

    public static char recognizeParentheseOpen() {
        return (interpreter.calu == '(') ? interpreter.calu : 0;
    }

    public static char recognizeParentheseClose() {
        return (interpreter.calu == ')') ? interpreter.calu : 0;
    }
}