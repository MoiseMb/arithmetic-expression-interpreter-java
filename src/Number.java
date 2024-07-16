package src;

public class Number {
    public double recognizeNumber() {
        StringBuilder nombre = new StringBuilder("");
        char chiffre;
        boolean hasComma = false;
        while (((chiffre = Utils.recognizeDigit()) != 0) || (nombre.length() != 0 && (chiffre = Utils.recognizeDot()) != 0) || (nombre.length() == 0 && (chiffre = Utils.recognizeAdditiveOperator()) != 0)) {
            if (chiffre == '.') {
                if (!hasComma) {
                    hasComma = true;
                } else {
                    interpreter.error.errorFactor = 1;
                    return -1;
                }
            }
            nombre.append(chiffre);
            Utils.readCharacter();
        }
        if (nombre.length() == 0) {
            interpreter.error.errorFactor = 1;
            return -1;
        } else {
            return Double.parseDouble(nombre.toString());
        }
    }
}
