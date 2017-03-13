package br.edu.ufcg.projetolp2.exceptions;

public class ValidacaoException extends RuntimeException{

	private static final long serialVersionUID = -5816144152590026893L;

	public ValidacaoException() {

	}

	public ValidacaoException(Exception e) {
		super(e);
	}

	public ValidacaoException(String message) {
		super(message);
	}

	public ValidacaoException(Exception e, String message) {
		super(message, e);
	}

}
