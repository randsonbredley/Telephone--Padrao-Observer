package telephone;

/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 *  System.out.println("hello");
 */
public class Screen {
    private final PhoneModel model;

    public Screen(PhoneModel model) {
        this.model = model;
        registerObservers();
    }
    
    private void registerObservers() {
        // Observador 1: Imprime o dígito mais recente
        model.addObserver(new PhoneObserver() {
            @Override
            public void digitAdded(int digit) {
                System.out.println(digit);
            }
        });

        // Observador 2: Imprime o número completo acumulado
        model.addObserver(new PhoneObserver() {
            @Override
            public void digitAdded(int digit) {
                StringBuilder sb = new StringBuilder();
                for (int d : model.getDigits()) {
                    sb.append(d);
                }
                System.out.println("Agora discando " + sb.toString() + "...");
            }
        });
    }
}
