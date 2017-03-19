package br.edu.ufcg.projetolp2.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.projetolp2.exceptions.PessoaException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;

/**
 * Classe responsavel por gerenciar as pessoas do sistema. A classe fica
 * responsavel por guardar os objetos {@link Pessoa}, adicionar, remover,
 * pesquisar atributos e pesquisar objeto pessoa. Alem disso, a classe eh
 * responsavel pela validacao dos atributos de pessoa.
 * 
 * @author Juan
 *
 */
public class PessoaController {
	private Map<String, Pessoa> pessoas;

	public PessoaController() {
		pessoas = new HashMap<String, Pessoa>();
	}

	/**
	 * Recebe as informcoes de uma pessoa e a cadastra no sistema. Eh testado se
	 * ja existe uma pessoa com o mesmo cpf dado na entrada, se ja existir, eh
	 * gerada uma {@link PessoaException}.
	 * 
	 * @param - cpf
	 * @param - nome
	 * @param - email
	 * @return - cpf da pessoa adicionada
	 */
	public String cadastraPessoa(String cpf, String nome, String email) {
		if (pessoas.containsKey(cpf)) {
			throw new PessoaException("Erro no cadastro de pessoa: Pessoa com mesmo CPF ja cadastrada");
		} else {
			Pessoa pessoa = new Pessoa(nome, email, cpf);
			pessoas.put(cpf, pessoa);
			
			return cpf;
		}
	}

	/**
	 * Recebe o CPF de uma pessoa, pesquisa e se encontrar, remove aquela pessoa
	 * do mapa de pessoas.
	 * 
	 * @param - cpf
	 *            da pessoa a ser pesquisado.
	 * @throws - PessoaException
	 *             Se nao encontrada uma pessoa com esse CPF
	 */
	public void removePessoa(String cpf) {
		if (! pessoas.containsKey(cpf)){
			throw new PessoaException("Erro na consulta de pessoa: Pessoa nao encontrada");
		}
		Pessoa pessoa = getPessoa(cpf);
		pessoas.remove(pessoa.getCpf());
	}

	/**
	 * Recebe o CPF de uma pessoa, pesquisa e se encontrar, ira retornado um
	 * objeto {@link Pessoa} com o respectivo CPF.
	 * 
	 * @param - cpf
	 *            a ser pesquisado.
	 * @return
	 * @throws - PessoaException
	 */
	public Pessoa getPessoa(String cpf) {
		if (! pessoas.containsKey(cpf)){
			throw new PessoaException("Erro na consulta de pessoa: Pessoa nao encontrada");
		}
		return pessoas.get(cpf);
	}

	/**
	 * Recupera uma infomacao de pessoa com base no atributo escolhido 
	 * @param cpf - cpf da pessoa a ser recuperado a informacao	
	 * @param atributo -  atributo que se deseja recuperar
	 * @return - o valor do atributo 
	 */
	public String getInfoPessoa(String cpf, String atributo) {
		if (!pessoas.containsKey(cpf)){
			throw new PessoaException("Erro na consulta de pessoa: Pessoa nao encontrada");
		}
		return pessoas.get(cpf).getInfo(atributo);
		
	}

	/**
	 * Edita um parametro de uma pessoa de acordo com com o atributo escolhido
	 * @param cpf - cpf da pessoa que sera editada
	 * @param atributo -  atributo de pessoa que se deseja editar
	 * @param valor - o novo valor que o atributo tera 
	 */
	public void editaPessoa(String cpf, String atributo, String valor) {
		if (!pessoas.containsKey(cpf)){
			throw new PessoaException("Erro na consulta de pessoa: Pessoa nao encontrada");
		}
		pessoas.get(cpf).setInfo(atributo, valor);
		
	}

	/**
	 * Adiciona da lista de participacao do usuario a nova participacao
	 * @param participacao - participacao a ser adicionada
	 * @param cpf -  cpf da pessoa ao qual a aparticipacao sera adicionada
	 */
	public void adicionaParticipacao(Participacao participacao, String cpf) {
		if (!pessoas.containsKey(cpf)){
			throw new PessoaException("Erro na associacao de pessoa a projeto: Pessoa nao encontrada");
		}
		pessoas.get(cpf).adicionaParticipacao(participacao);
	}

	/**
	 * Remove da lista de participacao do usuario a participacao
	 * @param participacao - participacao a ser removida
	 * @param cpf - cpf da pessoa que a participacao sera removida
	 */
	public void removeParticipacao(String cpf, int codProjeto) {
		if (!pessoas.containsKey(cpf)){
			throw new PessoaException("Erro na remocao de participacao: Pessoa nao encontrada");
		}
		pessoas.get(cpf).removeParticipacao(codProjeto);
	}

	/**
	 * Remove a partipaco de todas as pessoas associadas ao projeto ao qual pertence codigo
	 * @param codProjeto - codigo do projeto a ser removido
	 */
	public void removeParticipacao(int codProjeto) {  
			Set<String> cpfs = pessoas.keySet();
			for (String cpf : cpfs) {
				pessoas.get(cpf).removeParticipacao(codProjeto);
			}
		}
	
	/**
	 * Calcula e retorna a quantidade de pontuacao da pessoa portadora do cpf passado
	 * @param cpf - cpf da pessoa que sera feito o calculo de pontuacao 
	 * @return - prontucao totas da pessoa portadora do @cpf 
	 */
	public double calculaPontuacaoPorParticipacao(String cpf) {
		if (!pessoas.containsKey(cpf)){
			throw new PessoaException(); 
		}
		return pessoas.get(cpf).getPontuacaoParticipacao();
	}
}
