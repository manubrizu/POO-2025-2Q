package PARCIALES.P20242C.ej1;

import java.time.YearMonth;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

public class YearMonthRange implements Iterable<YearMonth> {
    private YearMonth start, end;
    private UnaryOperator<YearMonth> salto;

    YearMonthRange(YearMonth start, YearMonth end, UnaryOperator<YearMonth> salto) {
        this.start = start;
        this.end = end;
        this.salto = salto;
    }

    YearMonthRange(YearMonth start, YearMonth end) {                                    ///  NO TENGO QUE REPETIR CODIGO, INCREMENTO DE A 1 MES POR DEFAULT
        this(start, end, yearMonth -> yearMonth.plusMonths(1));
    }

    @Override
    public Iterator<YearMonth> iterator() {
        return new YearMonthRangeIterator();
    }

    public class YearMonthRangeIterator implements Iterator<YearMonth> {
        private YearMonth current = start;

        @Override
        public boolean hasNext() {
            return current.isBefore(end);
        }

        @Override
        public YearMonth next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            YearMonth toReturn = current;
            current = salto.apply(current);
            return toReturn;
        }
    }
}
