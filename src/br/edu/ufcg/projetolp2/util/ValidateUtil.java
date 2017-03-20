package br.edu.ufcg.projetolp2.util;

import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;

public class ValidateUtil {
	
	/**
	 * Valida um texto testando se ela obecede a estrutura de um cpf. Isso
	 * equivale dizer que não é possível ter caracteres especiais, letras ou
	 * simbolos que não estejam previamente estabelecidos. Um CPF é composto por
	 * uma sequência de três números, um ponto, três vezes, seguido por um traço
	 * e dois números.
	 * 
	 * @param cpf
	 * @throws e
	 *             Se validação não passar, é gerada uma
	 *             {@link ValidacaoException}
	 */
	public static void validaCpf(String cpf) {
		if (cpf == null || cpf.trim().equals("")) {
			throw new ValidacaoException("CPF nulo ou vazio");

		}
		if (!cpf.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
			throw new ValidacaoException("CPF invalido");
		}
	}
	
	public static void validaString(String str, String msg) throws ValidacaoException {
		if (str == null || str.trim().equals("")) {
			throw new ValidacaoException(msg);
		}
	}

	/**
	 * Valida um texto testando se ela obecede a estrutura de um email. Isso
	 * equivale dizer que não é possível ter caracteres especiais a não ser o
	 * "@" que só deve aparecer uma vez. Além disso, é checado se existem "."
	 * irregulares no email.
	 * 
	 * @param email
	 *            texto a ser testado
	 * @throws e
	 *             Se validação não passar, é gerada uma
	 *             {@link ValidacaoException}
	 */
	public static void validaEmail(String email) throws ValidacaoException{
		if (email == null || email.trim().equals("")){
			throw new ValidacaoException("Email nulo ou vazio");
		}
		String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)"
				+ "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\"
				+ "x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]"
				+ "(?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25"
				+ "[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\"
				+ "x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		if (!email.matches(regex)) {
			throw new ValidacaoException("Email invalido");
		}
	}
	
	public static void validaImpacto(int impacto) throws ValidacaoException {
		//TODO
	}
	
	public static void validaPositivo(double numero) throws ValidacaoException {
		//TODO
	}
	
	public static void validaData(String data) throws ValidacaoException {
		//TODO
	}

	public static void validaRendimento(int rendimento) {
		// TODO Auto-generated method stub
		
	}	
}
