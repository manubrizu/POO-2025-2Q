package TPS.TP7.ej2;

@FunctionalInterface
public interface Reducer<ValueIn, ValueOut> {
    ValueOut reduce(ValueOut accum, ValueIn value);
}
