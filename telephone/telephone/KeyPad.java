package telephone;

import java.util.Random;

/**
 * Mimic the data input ability of a physical phone's keypad;
 * however, here we're just sending it fake digits.
 */
public class KeyPad {
    private final PhoneModel model;

    public KeyPad(PhoneModel model) {
        this.model = model;
    }

    public void simulateKeyPress(int digit) {
        System.out.println("Pressionando: " + digit);
        model.addDigit(digit);
    }

}
