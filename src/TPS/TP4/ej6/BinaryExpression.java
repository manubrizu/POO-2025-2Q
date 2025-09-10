package TPS.TP4.ej6;

public abstract class BinaryExpression extends Expression{
    protected Expression leftExpression, rightExpression;

    public abstract boolean evaluate();

    BinaryExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}
