/**
 * Classe para implementação da Tratativa de Erros
 */
package erros;

/**
 * @author Martinelli
 * @version 1.0.0.0
 * @category Acadêmico
 */
public class SisVendasException extends Exception {

	public SisVendasException() {
		super();
	}

	public SisVendasException(String message) {
		super(message);
	}
}
