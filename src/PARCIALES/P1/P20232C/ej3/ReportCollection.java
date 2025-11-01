package PARCIALES.P1.P20232C.ej3;

public interface ReportCollection<R> {
    void add(R report);
    R get(int index);
    R[] reports();
}
