package br.edu.ufcg.projetolp2.model.participacao.tipos;

public class ParticipacaoGraduando implements TipoParticipacao {

	@Override
	public String getTipoParticipacao() {
		return TipoParticipacao.GRADUANDO;
	}

	@Override
	public double calculaPontos() {
		// TODO Auto-generated method stub
		return 0;
	}

}
