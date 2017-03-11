package br.edu.ufcg.projetolp2.model.pessoa;

import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;

public class Pessoa {

	private String nome;

	private String email;

	private String cpf;

	public Pessoa(String nome, String email, String cpf) {
		if (validaNome(nome)){
			throw new ValidacaoException("Nome nulo ou vazio");
		}

		if (validaEmail(email)) {
			throw new ValidacaoException("Email invalido");
		}

		if (validaCpf(cpf)) {
			throw new ValidacaoException("CPF invalido");
		}

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	/**
	 * Valida um texto testando se ela obecede a estrutura de um nome. 
	 * 
	 * @param email texto a ser testado
	 * @return true se for válido, false se for inválido.
	 */
	private boolean validaNome(String nome) {
		return (nome == null || nome.trim().equals("") ? false : true);
	}
	

	/**
	 * Valida um texto testando se ela obecede a estrutura de um email. Isso
	 * equivale dizer que não é possível ter caracteres especiais a não ser o
	 * "@" que só deve aparecer uma vez. Além disso, é checado se existem "."
	 * irregulares no email.
	 * 
	 * @param email texto a ser testado
	 * @return true se for válido, false se for inválido.
	 */
	private boolean validaEmail(String email) {
		if (email == null) {
			return false;
		}
		int posicao_arroba = email.indexOf("@");
		if (posicao_arroba <= 1) {
			return false;
		}
		return email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)"
				+ "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\"
				+ "x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]"
				+ "(?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25"
				+ "[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\"
				+ "x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
	}

	/**
	 * Valida um texto testando se ela obecede a estrutura de um cpf. Isso
	 * equivale dizer que não é possível ter caracteres especiais, letras ou
	 * simbolos que não estejam previamente estabelecidos. Um CPF é composto 
	 * por uma sequência de três números, um ponto, três vezes, seguido por um
	 * traço e dois números.
	 * 
	 * @param cpf  texto a ser testado
	 * @return true se for válido, false se for inválido.
	 */
	private boolean validaCpf(String cpf) {
		if (cpf == null){
			return false;
		}
		
		return email.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
