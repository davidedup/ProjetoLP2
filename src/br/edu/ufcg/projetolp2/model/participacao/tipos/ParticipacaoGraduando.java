package br.edu.ufcg.projetolp2.model.participacao.tipos;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;

public class ParticipacaoGraduando extends Participacao {

	public ParticipacaoGraduando(Projeto projeto, Pessoa pessoa, int horasSemanais, double valorHora) {
		super(projeto, pessoa, horasSemanais, valorHora);
	}
	
	@Override
	public double calculaPontos(){
		int tempo = getProjeto().getDuracao() / 6;
		double res = 0;
		
		if (getProjeto().getClass() == Monitoria.class){
			res = Math.min(tempo * 1.5, 6);
		}
		
		if (getProjeto().getClass() == Pet.class || getProjeto().getClass() == Extensao.class || getProjeto() instanceof Ped){
			res += Math.min(tempo * 2, 8);
		}
		
		return res;
	}


}
