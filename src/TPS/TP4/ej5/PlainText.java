package TPS.TP4.ej5;

public class PlainText extends BasicText {
    private String text;

    PlainText(String text) {
        setText(text);
    }
    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String source() {
        return text;
    }
}
