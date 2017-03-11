package br.edu.ufcg.projetolp2.model.participacao.tipos;

public interface TipoParticipacao {
	
	public static final String PROFESSOR = "PROFESSOR";
	public static final String PROFISSIONAL = "PROFISSIONAL";
	public static final String GRADUANDO = "GRADUANDO";
	public static final String PROFESSOR_COORDENADOR = "PROFESSOR COORDENADOR";
	
	String getTipoParticipacao();
}
