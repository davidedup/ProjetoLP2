package br.edu.ufcg.projetolp2.model.participacao.tipos;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;

public class ParticipacaoProfessor extends Participacao {
	private boolean coordenador;

	public ParticipacaoProfessor(Projeto projeto, Pessoa pessoa, int horasSemanais, double valorHora, boolean coordenador) {
		super(projeto, pessoa, horasSemanais, valorHora);
		
		this.coordenador = coordenador; 
	}
	
	public boolean getCoordenador() {
		return this.coordenador;
	}

	@Override
	public double calculaPontos(){
		int tempo = getProjeto().getDuracao()/12;
		double res = tempo * 4;
		
		if (getProjeto().getClass() != Monitoria.class){
			res += getProjeto().getTotalParticipacoes();
		}
		
		return res;
	}
}
