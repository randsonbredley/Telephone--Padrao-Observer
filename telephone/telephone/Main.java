package telephone;

public class Main {
    public static void main(String[] args) {
    	PhoneModel model = new PhoneModel();
        Screen screen = new Screen(model);
        KeyPad keyPad = new KeyPad(model);

        // Simulação com os dígitos do exemplo
        int[] digits = {0, 8, 1, 9, 9, 9, 8, 8, 7, 7, 6, 6};
        for (int digit : digits) {
            keyPad.simulateKeyPress(digit);
        }
    }
}
