package src;

public class Expression {
    public double recognizeExpression(ErreurManager error, char calu) {
        double term;
        char sign;
        double expression;
        Term expressionTerm = new Term();
        if ((term = expressionTerm.recognizeTerm(error, calu)) != -1 || error.errorExpression != 1) {
            if ((sign = Utils.recognizeAdditiveOperator(calu)) != 0) {
                Utils.readCharacter(calu);
                if (Utils.recognizeAdditiveOperator(calu) != 0) {
                    error.errorGlobal = 1;
                    error.errorExpression = 1;
                    return -1;
                }
                if (sign == '+') {
                    if ((expression = recognizeExpression(error, calu)) != -1 || error.errorExpression != 1) {
                        return (term + expression);
                    } else {
                        error.errorGlobal = 1;
                        return -1;
                    }
                } else {
                    if ((expression = recognizeExpression(error, calu)) != -1 || error.errorExpression != 1) {
                        return (term - expression);
                    } else {
                        error.errorGlobal = 1;
                        return -1;
                    }
                }
            } else {
                return term;
            }
        } else {
            error.errorGlobal = 1;
            return -1;
        }
    }
}
