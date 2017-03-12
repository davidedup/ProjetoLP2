package br.edu.ufcg.projetolp2.exceptions;

public class PessoaException extends RuntimeException{

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
