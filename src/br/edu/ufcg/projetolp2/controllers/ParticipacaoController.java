package br.edu.ufcg.projetolp2.controllers;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import br.edu.ufcg.projetolp2.exceptions.AssociacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfissional;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class ParticipacaoController {

	private Set<Participacao> participacoes;
	
	public ParticipacaoController() {
		participacoes = new HashSet<>();
	}

	public void associaProfessor(Pessoa pessoa, Projeto projeto, boolean coordenador, double valorHora, int qntHoras) {
		Participacao participacao = new Participacao(projeto, pessoa, qntHoras, valorHora, new ParticipacaoProfessor(coordenador));
		participacoes.add(participacao);
	}

	public void associaGraduando(Pessoa pessoa, Projeto projeto, double valorHora, int qntHoras) {
		Participacao participacao = new Participacao(projeto, pessoa, qntHoras, valorHora, new ParticipacaoGraduando());
		participacoes.add(participacao);
	}

	public void associaProfissional(Pessoa pessoa, Projeto projeto, String cargo, double valorHora, int qntHoras) {
		Participacao participacao = new Participacao(projeto, pessoa, qntHoras, valorHora, new ParticipacaoProfissional());
		participacoes.add(participacao);
	}

	public void removeParticipacao(Pessoa pessoa, Projeto projeto) throws AssociacaoException {
		
		for (Iterator<Participacao> iterator = participacoes.iterator(); iterator.hasNext();) {
			Participacao participacao = iterator.next();	
			if (participacao.getProjeto().equals(projeto) && participacao.getPessoa().equals(pessoa)) {
				participacoes.remove(participacao);
				return;
			}
		}
		
		throw new AssociacaoException("Erro na remocao de participacao: Pessoa nao possui participacao no projeto indicado");		
	}

}
