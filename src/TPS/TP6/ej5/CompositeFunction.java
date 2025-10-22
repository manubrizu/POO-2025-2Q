package TPS.TP6.ej5;

import java.util.ArrayList;
import java.util.List;

public class CompositeFunction implements Function {
    private List<Function> functions = new ArrayList<>();

    public void addFunction(Function f) {
        functions.add(f);
    }

    @Override
    public double evaluate(double x) {
        double answer = x;
        if (functions.isEmpty()) {
            throw new IllegalStateException();
        }
        for (Function f : functions) {
            answer = f.evaluate(answer);
        }
        return answer;
    }
}
