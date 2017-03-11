package br.edu.ufcg.projetolp2.model.participacao.tipos;

public interface TipoParticipacao {
	
	public static final String PROFESSOR = "PROFESSOR";
	public static final String PROFISSIONAL = "PROFISSIONAL";
	public static final String GRADUANDO = "GRADUANDO";
	public static final String PROFESSOR_COORDENADOR = "PROFESSOR COORDENADOR";
	
	/**
	 * Método que retorna uma string informando qual o tipo de participação da pessoa no projeto
	 * @return String que pode ser:
	 * <ul>
	 * 	<li>{@value #PROFESSOR}</li>
	 *  <li>{@value #PROFISSIONAL}</li>
	 *  <li>{@value #GRADUANDO}</li>
	 *  <li>{@value #PROFESSOR_COORDENADOR}</li>
	 * </ul>
	 */
	String getTipoParticipacao();
}
