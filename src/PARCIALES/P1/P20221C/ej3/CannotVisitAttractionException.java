package PARCIALES.P1.P20221C.ej3;

public class CannotVisitAttractionException extends RuntimeException{
    private static final String MESSAGE = "Cannot Visit Attraction %s ";

    CannotVisitAttractionException(Attraction attraction){
        super(String.format(MESSAGE, attraction.toString()));
    }
}
