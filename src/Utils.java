package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {
    public static void readCharacter(char calu) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            do {
                calu = (char) reader.read();
            } while (calu == ' ' || calu == '\n' || calu == '\t');
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

    public static char recognizeDigit(char calu) {
        return (calu >= '0' && calu <= '9') ? calu : 0;
    }

    public static char recognizeDot(char calu) {
        return (calu == '.') ? calu : 0;
    }

    public static char recognizeAdditiveOperator(char calu) {
        return (calu == '+' || calu == '-') ? calu : 0;
    }

    public static char recognizeMultiplicativeOperator(char calu) {
        return (calu == '*' || calu == '/') ? calu : 0;
    }

    public static char recognizeParentheseOpen(char calu) {
        return (calu == '(') ? calu : 0;
    }

    public static char recognizeParentheseClose(char calu) {
        return (calu == ')') ? calu : 0;
    }
}