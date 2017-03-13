package br.edu.ufcg.projetolp2.exceptions;

public class FactoryException extends Exception {

	private static final long serialVersionUID = -4580972920465002100L;
	
	public FactoryException() {

	}

	public FactoryException(Exception e) {
		super(e);
	}

	public FactoryException(String message) {
		super(message);
	}

	public FactoryException(Exception e, String message) {
		super(message, e);
	}

}
