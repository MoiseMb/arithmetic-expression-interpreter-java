package src;

public class Term {
    public double recognizeTerm(ErreurManager error, char calu) {
        double facteur;
        char sign;
        double term;
        Factor expressionFactor = new Factor();
        if ((facteur = expressionFactor.recognizeFactor(error, calu)) != -1 || error.errorTerm != 1) {
            if ((sign = Utils.recognizeMultiplicativeOperator(calu)) != 0) {
                Utils.readCharacter(calu);
                if (Utils.recognizeMultiplicativeOperator(calu) != 0) {
                    error.errorExpression = 1;
                    error.errorTerm = 1;
                    return -1;
                }
                if (sign == '*') {
                    if ((term = recognizeTerm(error, calu)) != -1 || error.errorTerm != 1) {
                        return (facteur * term);
                    } else {
                        error.errorExpression = 1;
                        return -1;
                    }
                } else {
                    if ((term = recognizeTerm(error, calu)) != -1 || error.errorTerm != 1) {
                        return (facteur / term);
                    } else {
                        error.errorExpression = 1;
                        return -1;
                    }
                }
            } else {
                return facteur;
            }
        } else {
            error.errorExpression = 1;
            return -1;
        }
    }
}
