package br.edu.ufcg.projetolp2.model.participacao.tipos;

public class ParticipacaoProfessor implements TipoParticipacao {

	private boolean coordenador;

	public ParticipacaoProfessor(boolean coordenador) {
		this.coordenador = coordenador;
	}
	
	public boolean getCoordenador() {
		return this.coordenador;
	}

	@Override
	public double calculaPontos() {
		// TODO Auto-generated method stub
		return 0;
	}
}
