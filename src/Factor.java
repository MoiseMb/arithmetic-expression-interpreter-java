package src;

public class Factor {
    public double recognizeFactor(ErreurManager error, char calu) {
        double nombre;
        double expression;
        Expression expressionExpression = new Expression();
        Number expressionNumber = new Number();
        if ((nombre = expressionNumber.recognizeNumber(error, calu)) != -1 || error.errorFactor != 1) {
            return nombre;
        } else if (Utils.recognizeParentheseOpen(calu) != 0) {
            Utils.readCharacter(calu);
            expression = expressionExpression.recognizeExpression(error, calu);
            if (Utils.recognizeParentheseClose(calu) != 0) {
                Utils.readCharacter(calu);
                return expression;
            } else {
                error.errorTerm = 1;
                return -1;
            }
        } else {
            error.errorTerm = 1;
            return -1;
        }
    }
}
