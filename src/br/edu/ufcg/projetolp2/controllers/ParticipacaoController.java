package br.edu.ufcg.projetolp2.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.projetolp2.exceptions.AssociacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfissional;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class ParticipacaoController {

	private List<Participacao> participacoes;
	
	public ParticipacaoController() {
		participacoes = new ArrayList<>();
	}

	/**
	 * Método responsável por associar um professor à um projeto.
	 * 
	 * @param professor - objeto pessoa a ser associado
	 * @param projeto - objeto projeto ao qual o professor fará parte
	 * @param coordenador - boolean informando se o professor será coordenador do projeto
	 * @param valorHora - double representando o valor da hora de trabalho do professor
	 * @param qntHoras - int representando a quantidade de horas semanais que o professor trabalhará
	 */
	public void associaProfessor(Pessoa professor, Projeto projeto, boolean coordenador, double valorHora, int qntHoras) {
		Participacao participacao = new Participacao(projeto, professor, qntHoras, valorHora, new ParticipacaoProfessor(coordenador));
		participacoes.add(participacao);
	}

	/**
	 * Método responsável por associar um graduando à um projeto.
	 * 
	 * @param graduando - objeto pessoa a ser associado
	 * @param projeto - objeto projeto ao qual o graduando fará parte
	 * @param valorHora - double representando o valor da hora de trabalho do graduando
	 * @param qntHoras - int representando a quantidade de horas semanais que o graduando trabalhará
	 */
	public void associaGraduando(Pessoa graduando, Projeto projeto, double valorHora, int qntHoras) {
		Participacao participacao = new Participacao(projeto, graduando, qntHoras, valorHora, new ParticipacaoGraduando());
		participacoes.add(participacao);
	}

	/**
	 * Método responsável por associar um profissional à um projeto.
	 * 
	 * @param graduando - objeto pessoa a ser associado
	 * @param projeto - objeto projeto ao qual o graduando fará parte
	 * @param valorHora - double representando o valor da hora de trabalho do graduando
	 * @param qntHoras - int representando a quantidade de horas semanais que o graduando trabalhará
	 * @param cargo - String representando o cargo do profissional no projeto
	 */
	public void associaProfissional(Pessoa profissional, Projeto projeto, String cargo, double valorHora, int qntHoras) {
		Participacao participacao = new Participacao(projeto, profissional, qntHoras, valorHora, new ParticipacaoProfissional());
		participacoes.add(participacao);
	}

	/**
	 * Método responsável por remover a associação que uma pessoa tem em um determinado projeto
	 * 
	 * @param pessoa - pessoa cuja participação deve ser removida
	 * @param projeto - projeto cuja participação de determinada pessoa deve ser removida
	 * @throws AssociacaoException caso a pessoa não esteja associada ao determinado projeto
	 */
	public void removeParticipacao(Pessoa pessoa, Projeto projeto) throws AssociacaoException {
		for (Participacao participacao : participacoes) {
			if (participacao.getProjeto().equals(projeto) && participacao.getPessoa().equals(pessoa)) {
				participacoes.remove(participacao);
				return;
			}
		}
		throw new AssociacaoException("Erro na remocao de participacao: Pessoa nao possui participacao no projeto indicado");		
	}
	
	/**
	 * Método que retorna todas as participações de uma pessoa com qualquer projeto.
	 * @param pessoa
	 * @return Lista de todas as participações desta pessoa
	 */
	public List<Participacao> getParticipacoes (Pessoa pessoa) {
		List<Participacao> todasParticipacoesPessoa = new ArrayList<>();
		for (Participacao participacao : participacoes) {
			if (participacao.getPessoa().equals(pessoa)) {
				todasParticipacoesPessoa.add(participacao);
			}
		}
		return todasParticipacoesPessoa;
	}
	
	/**
	 * Método que retorna todas as participações que relacionam qualquer pessoa com um determinado projeto
	 * @param projeto
	 * @return Lista de todas as participações desde projeto
	 */
	public List<Participacao> getParticipacoes (Projeto projeto) {
		List<Participacao> todasParticipacoesProjeto = new ArrayList<>();
		for (Participacao participacao : participacoes) {
			if (participacao.getProjeto().equals(projeto)) {
				todasParticipacoesProjeto.add(participacao);
			}
		}
		return todasParticipacoesProjeto;
	}

}
