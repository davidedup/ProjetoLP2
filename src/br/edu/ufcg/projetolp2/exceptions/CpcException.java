package br.edu.ufcg.projetolp2.exceptions;

public class CpcException extends RuntimeException{

	private static final long serialVersionUID = -5468522644821887682L;

	public CpcException() {

	}

	public CpcException(Exception e) {
		super(e);
	}

	public CpcException(String message) {
		super(message);
	}

	public CpcException(Exception e, String message) {
		super(message, e);
	}

}
