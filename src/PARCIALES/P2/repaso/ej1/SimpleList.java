package PARCIALES.P2.repaso.ej1;

import java.util.List;
import java.util.Map;

public interface SimpleList<E> extends List<E> {
    <K> Map<K, E> toMap(Mapper<E, K> mapper);
    /// CON <K> DEFINO EL K YA QUE NO ESTABA DECLARADO

    ///  AL MAPPER LE TENGO QUE PASAR UN ELEMENT Y ME DEVUELVE UNA KEY
}
