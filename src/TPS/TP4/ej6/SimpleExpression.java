package TPS.TP4.ej6;

public class SimpleExpression extends Expression{
    private boolean value;

    SimpleExpression(boolean value){
        this.value = value;
    }

    @Override
    public boolean evaluate(){
        return this.value;
    }

    public void setValue(boolean value){
        this.value = value;
    }
}
