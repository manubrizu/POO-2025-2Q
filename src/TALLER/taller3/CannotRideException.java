package TALLER.taller3;

public class CannotRideException extends Exception{
    private static final String MESSAGE = "Nao nao, wua wua";

    public CannotRideException(String naoNao) {
        super(MESSAGE);
    }

}
