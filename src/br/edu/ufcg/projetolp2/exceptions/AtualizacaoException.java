package br.edu.ufcg.projetolp2.exceptions;

public class AtualizacaoException extends Exception{

	private static final long serialVersionUID = 2650519756225893141L;

	public AtualizacaoException() {

	}

	public AtualizacaoException(Exception e) {
		super(e);
	}

	public AtualizacaoException(String message) {
		super(message);
	}

	public AtualizacaoException(Exception e, String message) {
		super(message, e);
	}

}
