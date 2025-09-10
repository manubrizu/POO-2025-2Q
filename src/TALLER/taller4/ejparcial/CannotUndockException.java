package TALLER.taller4.ejparcial;

public class CannotUndockException extends Exception {
    private static final String MESSAGE = "Nao nao, wua wua";

    public CannotUndockException(String message){
        super(MESSAGE);
    }
}
