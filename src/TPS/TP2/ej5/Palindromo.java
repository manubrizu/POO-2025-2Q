package TPS.TP2.ej5;

public class Palindromo {
    public static void main(String[] args) {
        StringBuilder frase = new StringBuilder();
        for (String s : args) {
            frase.append(s.toLowerCase());
        }
        if (esPalindromo(frase.toString())) {
            System.out.println("ES PALINDROMO");
        } else {
            System.out.println("NO ES PALINDROMO");
        }
    }
    private static boolean esPalindromo(String palabra) {
        for (int i = 0; i < palabra.length()/2; i++) {
            if (palabra.charAt(i) != palabra.charAt(palabra.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
