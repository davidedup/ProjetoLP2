package br.edu.ufcg.projetolp2.controllers;

import java.util.HashMap;
import java.util.Map;

import br.edu.ufcg.projetolp2.exceptions.AtualizacaoException;
import br.edu.ufcg.projetolp2.exceptions.PessoaException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
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
		try {
			validaCpf(cpf);
			validaEmail(email);
			validaNome(nome);
		} catch (ValidacaoException e) {
			throw new PessoaException(e, "Erro no cadastro de pessoa: " + e.getMessage());
		}

		if (pessoas.containsKey(cpf)) {
			throw new PessoaException("Erro no cadastro de pessoa: Pessoa com mesmo CPF ja cadastrada");
		}

		Pessoa pessoa = new Pessoa(nome, email, cpf);
		pessoas.put(cpf, pessoa);

		return cpf;
	}

	/**
	 * Recebe um cpf, pesguisa a pessoa com esse CPF e 
	 * atualiza o nome da pessoa para o parâmetro passado.
	 * @param cpf da pessoa a ser pesquisada
	 * @param nome atualizado da pessoa
	 * @throws PessoaException Se não encontrada uma pessoa com esse CPF
	 */
	public void editaNome(String cpf, String nome) {
		try {
			validaCpf(cpf);
			validaNome(nome);
			Pessoa pessoa = getPessoa(cpf);
			pessoa.setNome(nome);
		} catch (ValidacaoException | PessoaException e) {
			throw new PessoaException(e, "Erro na atualizacao de pessoa: " + e.getMessage());
		}
	}

	/**
	 * Tenta atualizar um CPF. Atualmente, essa funcionalidade não deve
	 * ser efetuada, por essa razão, sempre é lançado um erro.
	 * @param cpfAtual
	 * @param cpfNovo
	 * @throws AtualizacaoException 
	 */
	public void editaCpf(String cpfAtual, String cpfNovo) throws PessoaException {
		throw new PessoaException("Erro na atualizacao de pessoa: CPF nao pode ser alterado");
	}

	/**
	 * Recebe um cpf, pesguisa a pessoa com esse CPF e 
	 * atualiza o email da pessoa para o parâmetro passado.
	 * @param cpf da pessoa a ser pesquisada
	 * @param email atualizado da pessoa
	 * @throws PessoaException Se não encontrada uma pessoa com esse CPF
	 */
	public void editaEmail(String cpf, String email) {
		try {
			validaCpf(cpf);
			validaEmail(email);
			Pessoa pessoa = getPessoa(cpf);
			pessoa.setEmail(email);
		} catch (ValidacaoException | PessoaException e) {
			throw new PessoaException(e, "Erro na atualizacao de pessoa: " + e.getMessage());
		}
	}

	/**
	 * Recebe um cpf, pesguisa a pessoa com esse CPF e 
	 * retorna o nome.
	 * @param cpf da pessoa a ser pesquisada
	 * @return nome
	 * @throws PessoaException Se não encontrada uma pessoa com esse CPF
	 */
	public String getNome(String cpf) {
		try {
			Pessoa pessoa = getPessoa(cpf);
			return pessoa.getNome();
		} catch (PessoaException e) {
			throw new PessoaException(e,"Erro na consulta de pessoa: " + e.getMessage());
		}
	}

	/**
	 * Recebe um cpf, pesguisa a pessoa com esse CPF e 
	 * retorna o email.
	 * @param cpf da pessoa a ser pesquisada
	 * @return email
	 * @throws PessoaException Se não encontrada uma pessoa com esse CPF
	 */
	public String getEmail(String cpf) {
		try {
			Pessoa pessoa = getPessoa(cpf);
			return pessoa.getEmail();
		} catch (PessoaException e) {
			throw new PessoaException(e,"Erro na consulta de pessoa: " + e.getMessage());
		}
	}

	/**
	 * Recebe o CPF de uma pessoa, pesquisa e se encontrar,
	 * remove aquela pessoa do mapa de pessoas.
	 * @param cpf da pessoa a ser pesquisado.
	 * @throws PessoaException Se não encontrada uma pessoa com esse CPF
	 */
	public void removePessoa(String cpf) {
		try {
			Pessoa pessoa = getPessoa(cpf);
			pessoas.remove(pessoa.getCpf());
		} catch (PessoaException e) {
			throw new PessoaException(e, "Erro na remocao de pessoa: " + e.getMessage());
		}
	}

	/**
	 * Recebe o CPF de uma pessoa, pesquisa e se encontrar,
	 * é retornado um objeto {@link Pessoa} com o respectivo
	 * CPF.
	 * @param cpf a ser pesquisado.
	 * @return
	 * @throws PessoaException
	 */
	public Pessoa getPessoa(String cpf) throws PessoaException {
		if (cpf != null && pessoas.containsKey(cpf)) {
			return pessoas.get(cpf);
		} else {
			throw new PessoaException("Pessoa nao encontrada");
		}
	}

	/**
	 * Valida um texto testando se ela obecede a estrutura de um nome.
	 * 
	 * @param email
	 *            texto a ser testado
	 * @throws e
	 *             Se validação não passar, é gerada uma
	 *             {@link ValidacaoException}
	 */
	private void validaNome(String nome) throws ValidacaoException {
		if (nome == null || nome.trim().equals("")) {
			throw new ValidacaoException("Nome nulo ou vazio");
		}
	}

	/**
	 * Valida um texto testando se ela obecede a estrutura de um email. Isso
	 * equivale dizer que não é possível ter caracteres especiais a não ser o
	 * "@" que só deve aparecer uma vez. Além disso, é checado se existem "."
	 * irregulares no email.
	 * 
	 * @param email
	 *            texto a ser testado
	 * @throws e
	 *             Se validação não passar, é gerada uma
	 *             {@link ValidacaoException}
	 */
	private void validaEmail(String email) throws ValidacaoException{
		if (email == null || email.trim().equals("")){
			throw new ValidacaoException("Email nulo ou vazio");
		}
		String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)"
				+ "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\"
				+ "x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]"
				+ "(?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25"
				+ "[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\"
				+ "x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		if (!email.matches(regex)) {
			throw new ValidacaoException("Email invalido");
		}
	}

	/**
	 * Valida um texto testando se ela obecede a estrutura de um cpf. Isso
	 * equivale dizer que não é possível ter caracteres especiais, letras ou
	 * simbolos que não estejam previamente estabelecidos. Um CPF é composto por
	 * uma sequência de três números, um ponto, três vezes, seguido por um traço
	 * e dois números.
	 * 
	 * @param cpf
	 * @throws e
	 *             Se validação não passar, é gerada uma
	 *             {@link ValidacaoException}
	 */
	private void validaCpf(String cpf) {
		if (cpf == null || cpf.trim().equals("")) {
			throw new ValidacaoException("CPF nulo ou vazio");

		}
		if (!cpf.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
			throw new ValidacaoException("CPF invalido");
		}
	}

}
