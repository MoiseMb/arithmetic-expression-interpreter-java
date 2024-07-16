package src;

public class Term {
    public double recognizeTerm() {
        double facteur;
        char sign;
        double term;
        Factor expressionFactor = new Factor();
        if ((facteur = expressionFactor.recognizeFactor()) != -1 || interpreter.error.errorTerm != 1) {
            if ((sign = Utils.recognizeMultiplicativeOperator()) != 0) {
                Utils.readCharacter();
                if (Utils.recognizeMultiplicativeOperator() != 0) {
                    interpreter.error.errorExpression = 1;
                    interpreter.error.errorTerm = 1;
                    return -1;
                }
                if (sign == '*') {
                    if ((term = recognizeTerm()) != -1 || interpreter.error.errorTerm != 1) {
                        return (facteur * term);
                    } else {
                        interpreter.error.errorExpression = 1;
                        return -1;
                    }
                } else {
                    if ((term = recognizeTerm()) != -1 || interpreter.error.errorTerm != 1) {
                        return (facteur / term);
                    } else {
                        interpreter.error.errorExpression = 1;
                        return -1;
                    }
                }
            } else {
                return facteur;
            }
        } else {
            interpreter.error.errorExpression = 1;
            return -1;
        }
    }
}
