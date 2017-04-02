package br.edu.ufcg.projetolp2.exceptions;

public class LoggingException extends Exception{

	private static final long serialVersionUID = 324961397513807324L;
	
	public LoggingException() {
		super("Ocorreu um erro no logger");
	}

	public LoggingException(Exception e) {
		super(e);
	}

	public LoggingException(String message) {
		super(message);
	}

	public LoggingException(Exception e, String message) {
		super(message, e);
	}

}
