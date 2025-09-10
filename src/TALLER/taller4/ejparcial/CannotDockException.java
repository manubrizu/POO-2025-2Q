package TALLER.taller4.ejparcial;

public class CannotDockException extends Exception {
    private static final String MESSAGE = "Nao nao, wua wua";

    public CannotDockException(String message){
        super(MESSAGE);
    }
}
