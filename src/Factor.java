package src;

public class Factor {
    public double recognizeFactor() {
        double nombre;
        double expression;
        Expression expressionExpression = new Expression();
        Number expressionNumber = new Number();
        if ((nombre = expressionNumber.recognizeNumber()) != -1 || interpreter.error.errorFactor != 1) {
            return nombre;
        } else if (Utils.recognizeParentheseOpen() != 0) {
            Utils.readCharacter();
            expression = expressionExpression.recognizeExpression();
            if (Utils.recognizeParentheseClose() != 0) {
                Utils.readCharacter();
                return expression;
            } else {
                interpreter.error.errorTerm = 1;
                return -1;
            }
        } else {
            interpreter.error.errorTerm = 1;
            return -1;
        }
    }
}
