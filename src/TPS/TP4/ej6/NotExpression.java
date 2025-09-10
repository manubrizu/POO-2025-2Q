package TPS.TP4.ej6;

public class NotExpression extends Expression{
    private Expression expression;

    NotExpression(Expression expression){
        this.expression = expression;
    }

    @Override
    public boolean evaluate(){
        return !expression.evaluate();
    }
}
