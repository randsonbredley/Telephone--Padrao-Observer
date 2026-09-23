package telephone;

import java.util.ArrayList;
import java.util.List;

/**
 * Store a phone number, digit-by-digit
 * PADRÃO OBSERVER - Sujeito Concreto (Subject)
 * 
 * O que é: Armazena o estado do sistema (dígitos do telefone) e mantém
 * uma lista de observadores registrados que precisam ser notificados
 * a cada mudança de estado.
 * 
 * - Onde está o padrão? Nos métodos addObserver() e notifyObservers().
 * - Princípio SOLID: Respeita o Princípio do Inverso da Dependência (DIP)
 *   pois depende apenas da interface 'PhoneObserver', nunca da classe 'Screen'.
 */
public class PhoneModel {
    private List<Integer> digits = new ArrayList<>();
 // Lista flexível contendo todos os observadores inscritos
    private List<PhoneObserver> observers = new ArrayList<>();

    /**
     * Permite que novos observadores se inscrevam para receber notificações.
     */
    public void addObserver(PhoneObserver observer) {
        observers.add(observer);
    }
    /**
     * Adiciona um dígito ao histórico e engatilha a notificação.
     */
    public void addDigit(int newDigit) {
        digits.add(newDigit);
        notifyObservers(newDigit);// Notifica todos após mudar o estado
    }
    /**
     * Notifica cada observador registrado chamando o método da interface.
     */
    private void notifyObservers(int newDigit) {
        for (PhoneObserver observer : observers) {
            observer.digitAdded(newDigit);
        }
    }

    /**
     * Permite que os observadores consultem o histórico completo de dígitos.
     */
    public List<Integer> getDigits() {
        return digits;
    }
}
