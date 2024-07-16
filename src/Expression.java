package src;

public class Expression {
    public double recognizeExpression() {
        double term;
        char sign;
        double expression;
        Term expressionTerm = new Term();
        if ((term = expressionTerm.recognizeTerm()) != -1 || interpreter.error.errorExpression != 1) {
            if ((sign = Utils.recognizeAdditiveOperator()) != 0) {
                Utils.readCharacter();
                if (Utils.recognizeAdditiveOperator() != 0) {
                    interpreter.error.errorGlobal = 1;
                    interpreter.error.errorExpression = 1;
                    return -1;
                }
                if (sign == '+') {
                    if ((expression = recognizeExpression()) != -1 || interpreter.error.errorExpression != 1) {
                        return (term + expression);
                    } else {
                        interpreter.error.errorGlobal = 1;
                        return -1;
                    }
                } else {
                    if ((expression = recognizeExpression()) != -1 || interpreter.error.errorExpression != 1) {
                        return (term - expression);
                    } else {
                        interpreter.error.errorGlobal = 1;
                        return -1;
                    }
                }
            } else {
                return term;
            }
        } else {
            interpreter.error.errorGlobal = 1;
            return -1;
        }
    }
}
