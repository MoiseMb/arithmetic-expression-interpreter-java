package src;

public class Number {
    public double recognizeNumber(ErreurManager error, char calu) {
        StringBuilder nombre = new StringBuilder();
        char chiffre;
        boolean hasComma = false;
        while (((chiffre = Utils.recognizeDigit(calu)) != 0) || (nombre.length() != 0 && (chiffre = Utils.recognizeDot(calu)) != 0) || (nombre.length() == 0 && (chiffre = Utils.recognizeAdditiveOperator(calu)) != 0)) {
            if (chiffre == '.') {
                if (!hasComma) {
                    hasComma = true;
                } else {
                    error.errorFactor = 1;
                    return -1;
                }
            }
            nombre.append(chiffre);
            Utils.readCharacter(calu);
        }
        if (nombre.length() == 0) {
            error.errorFactor = 1;
            return -1;
        } else {
            return Double.parseDouble(nombre.toString());
        }
    }
}
