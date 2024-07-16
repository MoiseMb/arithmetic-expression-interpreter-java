package src;

public class interpreter {
    public static char calu;
    public static ErreurManager error = new ErreurManager();

    public void interpreterFonction() {
        int status;
        do {
            System.out.print("A vous : ");
            status = analizerAndExtractor();
        } while (status != 1);
        System.out.println("Au revoir...");
    }

    public int analizerAndExtractor() {
        Expression expressionExpression = new Expression();
        Utils.readCharacter();
        if (interpreter.calu == '.') {
            return 1;
        } else if (interpreter.calu == '=') {
            System.out.println("La syntaxe de l'expression est erronee");
            Utils.clearBuffer();
            return 0;
        } else {
            double expressionValue = 1.0;
            int temp;
            while (interpreter.calu != '=') {
                expressionValue = expressionExpression.recognizeExpression();
                if (interpreter.error.errorGlobal == 1) break;
            }
            temp = Utils.clearBuffer();
            if (interpreter.error.errorGlobal == 1 || temp != 0) {
                interpreter.error.errorGlobal = 0;
                interpreter.error.errorExpression = 0;
                interpreter.error.errorTerm = 0;
                interpreter.error.errorFactor = 0;
                System.out.println("La syntaxe de l'expression est erronee");
            } else {
                System.out.println("la syntaxe de l'expression est correcte");
                System.out.println("sa valeur est " + expressionValue);
            }
            return 0;
        }
    }
}
