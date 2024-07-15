package src;

public class Utils {
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