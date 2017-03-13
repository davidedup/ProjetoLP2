package br.edu.ufcg.projetolp2.exceptions;

public class ProjetoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProjetoException() {
		super("Ocorreu um erro no projeto");
	}

	public ProjetoException(Exception e) {
		super(e);
	}

	public ProjetoException(String message) {
		super(message);
	}

	public ProjetoException(Exception e, String message) {
		super(message, e);
	}

}
