package br.edu.ufcg.projetolp2.model.participacao.tipos;

public class ParticipacaoProfissional implements TipoParticipacao {

	private String cargo;
	
	public String getCargo() {
		return this.cargo;
	}

	@Override
	public double calculaPontos() {
		// TODO Auto-generated method stub
		return 0;
	}

}
