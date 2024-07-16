package src;

import java.util.Scanner;

public class Utils {
    public static void readCharacter(char calu) {
        Scanner scanner = new Scanner(System.in);
        do {
            calu = scanner.next().charAt(0);
        } while (calu == ' ' || calu == '\n' || calu == '\t');
        scanner.close();
    }

    public static int clearBuffer() {
        Scanner scanner = new Scanner(System.in);
        char temp;
        int retour = 0;
        do {
            temp = scanner.next().charAt(0);
            if (temp != ' ' && temp != '\t' && temp != '\n') {
                retour = -1;
            }
        } while (temp != '\n');
        scanner.close();
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