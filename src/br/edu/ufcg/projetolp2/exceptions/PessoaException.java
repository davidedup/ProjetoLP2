package br.edu.ufcg.projetolp2.exceptions;

public class PessoaException extends RuntimeException {

	private static final long serialVersionUID = 7209597388857332508L;

	public PessoaException() {

	}

	public PessoaException(Exception e) {
		super(e);
	}

	public PessoaException(String message) {
		super(message);
	}

	public PessoaException(Exception e, String message) {
		super(message, e);
	}
}