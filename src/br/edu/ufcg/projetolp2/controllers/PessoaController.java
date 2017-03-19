package br.edu.ufcg.projetolp2.controllers;

import java.util.HashMap;
import java.util.Map;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;

/**
 * Classe responsável por gerenciar as pessoas do sistema.
 * A classe fica responsável por guardar os objetos {@link Pessoa},
 * adicionar, remover, pesquisar atributos e pesquisar objeto pessoa.
 * Além disso, a classe é responsável pela validação dos atributos de pessoa.
 * @author Juan
 *
 */
public class PessoaController {
	private Map<String, Pessoa> pessoas;

	public PessoaController() {
		pessoas = new HashMap<String, Pessoa>();
	}

	/**
	 * Recebe as informações de uma pessoa e a cadastra no sistema. É testado se
	 * já existe uma pessoa com o mesmo cpf dado na entrada, se já existir, é
	 * gerada uma {@link PessoaException}.
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @return cpf da pessoa adicionada
	 */
	public String cadastraPessoa(String cpf, String nome, String email) {
		
		//TODO VALIDAÇÃO
		
		Pessoa pessoa = new Pessoa(nome, email, cpf);
		pessoas.put(cpf, pessoa);

		return cpf;
	}

	/**
	 * Recebe o CPF de uma pessoa, pesquisa e se encontrar,
	 * remove aquela pessoa do mapa de pessoas.
	 * @param cpf da pessoa a ser pesquisado.
	 * @throws PessoaException Se não encontrada uma pessoa com esse CPF
	 */
	public void removePessoa(String cpf) {
		//TODO EXCEPTION
		Pessoa pessoa = getPessoa(cpf);
		pessoas.remove(pessoa.getCpf());
	}

	/**
	 * Recebe o CPF de uma pessoa, pesquisa e se encontrar,
	 * é retornado um objeto {@link Pessoa} com o respectivo
	 * CPF.
	 * @param cpf a ser pesquisado.
	 * @return
	 * @throws PessoaException
	 */
	public Pessoa getPessoa(String cpf) {
		//TODO EXCEPTION
		return pessoas.get(cpf);
	}
	
	public String getInfoPessoa(String cpf, String atributo) {
		//TODO
		return null;
	}
	
	public String editaPessoa(String cpf, String atributo, String valor) {
		//TODO
		return null;
	}
	
	public void adicionaParticipacao (Participacao participacao) {
		//TODO
	}
	
	public void removeParticipacao(String cpf, int codProjeto) {
		//TODO
	}
	
	public void removeParticipacao(int codProjeto) {
		//TODO
	}
	
	public double calculaPontuacaoPorParticipacao(String cpf) {
		//TODO
		return 0;
	}
}
