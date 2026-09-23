package telephone;
/**
* PADRÃO OBSERVER - Interface do Observador (Observer)
* 
* O que é: Define o contrato genérico que qualquer classe interessada
* em ouvir mudanças no telefone deve implementar.
* 
* - Onde está o padrão? Esta é a abstração do Observador.
* - Desacoplamento: O PhoneModel só conhece esta interface, sem saber
*   se quem a implementa é uma tela, um autofalante ou um logger.
*/
public interface PhoneObserver {
	/**
     * Método chamado pelo Sujeito (PhoneModel) sempre que um novo
     * dígito for digitado.
     */
	void digitAdded(int digit);

}
