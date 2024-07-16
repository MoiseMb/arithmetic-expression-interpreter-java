package src;

public class interpreter {
    public char calu;
    ErreurManager error = new ErreurManager();

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
        Utils.readCharacter(calu);
        if (calu == '.') {
            return 1;
        } else if (calu == '=') {
            System.out.println("La syntaxe de l'expression est erronee");
            Utils.clearBuffer();
            return 0;
        } else {
            double expressionValue = 1.0;
            int temp;
            while (calu != '=') {
                expressionValue = expressionExpression.recognizeExpression(error, calu);
                if (error.errorGlobal == 1) break;
            }
            temp = Utils.clearBuffer();
            if (error.errorGlobal == 1 || temp != 0) {
                error.errorGlobal = 0;
                error.errorExpression = 0;
                error.errorTerm = 0;
                error.errorFactor = 0;
                System.out.println("La syntaxe de l'expression est erronee");
            } else {
                System.out.println("la syntaxe de l'expression est correcte");
                System.out.println("sa valeur est " + expressionValue);
            }
            return 0;
        }
    }
}
