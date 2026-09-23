package telephone;

/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 *  System.out.println("hello");
 *  * PADRÃO OBSERVER - Cliente / Observadores Concretos (Concrete Observers)
 * 
 * O que faz: Representa a Interface de Usuário (UI). É a ÚNICA classe
 * autorizada pelo enunciado a imprimir coisas na tela (System.out.println).
 * 
 * - Onde está o padrão? Dentro do método registerObservers(), que instancia
 *   classes anônimas de 'PhoneObserver' e as registra no modelo.
 * 
 * - Como ESCALONAR? "Se quisermos um observador que emite um som ou envia SMS?"
 *   Basta criar um novo PhoneObserver e fazer model.addObserver(...) sem alterar o PhoneModel".
 */
public class Screen {
    private final PhoneModel model;
    private static final int NUMERO_DIGITOS_COMPLETO = 12; // Quantidade de dígitos para discar

    public Screen(PhoneModel model) {
        this.model = model;
        registerObservers();
    }
    
    private void registerObservers() {
        // Observador 1: Imprime o dígito mais recente recebido
        model.addObserver(new PhoneObserver() {
            @Override
            public void digitAdded(int digit) {
                System.out.println(digit);
            }
        });

        // Observador 2: Imprime o número completo acumulado e imprime a mensagem de discagem
        model.addObserver(new PhoneObserver() {
            @Override
            public void digitAdded(int digit) {
            	// Verifica se a quantidade total de dígitos atingiu o tamanho do número completo
                if (model.getDigits().size() == NUMERO_DIGITOS_COMPLETO) {
                    StringBuilder sb = new StringBuilder();
                    for (int d : model.getDigits()) {
                        sb.append(d);
                    }
                    System.out.println("Agora discando " + sb.toString() + "...");
                }
            }
        });            	
    }
}
