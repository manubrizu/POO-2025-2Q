package TPS.TP4.ej6;

public class OrExpression extends BinaryExpression {

    OrExpression(Expression lExpression, Expression rExpression){
        super(lExpression, rExpression);
    }

    @Override
    public boolean evaluate(){
        return leftExpression.evaluate() || rightExpression.evaluate();
    }
}
