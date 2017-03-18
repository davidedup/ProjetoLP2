package br.edu.ufcg.projetolp2.controllers;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;

public class MainController {

	private PessoaController pessoaController;
	private ProjetoController projetoController;
	
	public MainController () {
		projetoController = new ProjetoController();
		pessoaController = new PessoaController();
	}

	public void iniciaSistema() {
		
	}

	public void fechaSistema() {
	
	}

	/**
	 * Este método faz o cadastro da pessoa no sistema
	 * @param cpf - CPF é uma String unica da pessoa a ser cadastrada
	 * @param nome - Nome da Pessoa a ser cadastrada
	 * @param email - Email da pessoa a ser cadastrada 
	 * @return cpf da pessoa cadastrada
	 */
	public String cadastraPessoa(String cpf, String nome, String email) {
		return pessoaController.cadastraPessoa(cpf, nome, email);
	}

	/**
	 * Este método edita os dados da pessoa com base no atributo passado que se deseja editar, não pode editar o CPF
	 * @param cpf - CPF da pessoa a ser editada
	 * @param atributo - atributo de Pessoa que se deseja editar
	 * @param valor - Novo valor que o atributo escolhido editado irá ter
	 */
	public void editaPessoa(String cpf, String atributo, String valor) {
		
	}

	/**
	 * Este método retorna o atributo de pessoa desejado com base no valor atributo.
	 * @param cpf - CPF da pessoa que se quer a informação
	 * @param atributo - Qual o atributo de pessoa que irá ser retornardo
	 * @return pode retornar o nome ou email, ambos String
	 */
	public String getInfoPessoa(String cpf, String atributo) {
		//TODO
		return null;
	}

	/**
	 * Este método remove a pessoa portadora do CPF passado
	 * @param cpf - CPF da pessoa que se deseja remover
	 */
	public void removePessoa(String cpf) {
		pessoaController.removePessoa(cpf);
	}
	
	/**
	 * Cria uma monitoria e retorna seu codigo
	 * @param nome - nome do projeto 
	 * @param disciplina - disciplina que a monitoria atende
	 * @param rendimento - rendimento que varia de 0-100%
	 * @param objetivo - descricao do objetivo da monitoria 
	 * @param periodo - periodo no qual a monitoria esta atuando
	 * @param dataInicio - data de inicio da monitoria
	 * @param duracao - duracao em meses da monitoria 
	 * @return o codigo da monitoria adicionada
	 */
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) {
		return projetoController.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
	}

	/**
	 *  Cria um projeto do tipo PET e retorna seu codigo
	 * @param nome - nome do projeto PET
	 * @param objetivo - descrição do objetivo do projeto PET
	 * @param impacto - varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil)
	 * @param rendimento - rendimento que varia de 0-100%
	 * @param prodTecnica - quatidade de produções tecnicas
	 * @param prodAcademica - quantidade de produções acadêmicas
	 * @param patentes - quantidades de patentes
	 * @param dataInicio - data em que o projeto come�ou
	 * @param duracao - duracoa em meses do projeto
	 * @return - o codigo do projeto adicionado
	 */
	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) {
		return projetoController.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
	}
	
	/**
	 * Cria um projeto do tipo P&D e retorna seu codigo
	 * @param nome do projeto do tipo P&D
	 * @param categoria - Determina a categoria do projeto Coopera��o, PIBIC,PIBITI ou PIVIC
	 * @param prodTecnica - quatidade de produções tecnicas
	 * @param prodAcademica - quantidade de procuções acadêmicas
	 * @param patentes - quantidades de patentes
	 * @param objetivo -  descreve o objetivo do projeto
	 * @param dataInicio - data em que o projeto come�ou
	 * @param duracao - duracao em meses do projeto
	 * @return - o codigo do projeto adicionado
	 */
	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) {
		try {
			return projetoController.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		} catch (ValidacaoException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
	}

	/**
	 * Cria um projeto do tipo extens�o e retorna seu codigo
	 * @param nome - nome do projeto de exensão
	 * @param objetivo - descricao do obejtivo do projeto
	 * @param impacto - varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil)
	 * @param dataInicio - data em que o projeto começou
	 * @param duracao -duracao em meses do projeto
	 * @return - codigo do projeto adicionado
	 */
	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		return projetoController.adicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);
	}

	/**
	 * Recupera uma informacao do projeto com base no atributo requerido
	 * @param cod - codigo do projeto
	 * @param atributo - atributo que se deseja recuperar
	 * @return - retorna o atributo requerido no formato de String
	 */
	public String getInfoProjeto(int cod, String atributo) {
		return null;
	}
	
	public int getCodigoProjeto(String nomeProjeto) {
		return 0;
	}

	/**
	 * Recebe o codigo e um atributo do projeto e edita uma informa��o do projeto com base no atributo requerido com um novo valor que foi recebido
	 * @param codigo - codigo do projeto a ser editado
	 * @param atributo - atributo do projeto que se deseja editar
	 * @param valor -  novo valor que o atributo requerido ser� atulizado
	 */
	public void editaProjeto(int codigo, String atributo, String valor) {
		
	}

	/**
	 * Remove um projeto com base em seu codigo
	 * @param codigo - codigo do projeto a ser removido
	 */
	public void removeProjeto(int codigo) {
		projetoController.removeProjeto(codigo);
	}
	
	/**
	 * Faz a associação de um professor a um projeto
	 * @param cpfPessoa - cpf da pessoa a ser associada
	 * @param codigoProjeto - projeto ao qual o professor ser� associado
	 * @param coordenador - Flag para saber se � um professor coordenador
	 * @param valorHora - valor R$ da hora do professor
	 * @param qntHoras -  quantidade de horas semanais dedicada ao projeto
	 */
	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras) {

	}
	
	/**
	 * Faz a associação de um graduando a um projeto
	 * @param cpfPessoa - cpf da pessoa a ser associada
	 * @param codigoProjeto - projeto ao qual o graduando ser� associado
	 * @param valorHora - valor R$ da hora do graduando
	 * @param qntHoras -  quantidade de horas semanais dedicadas ao projeto
	 */
	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras) {

	}
	
	/**
	 * Faz a associação de um profissional a um projeto
	 * @param cpfPessoa - cpf da pessoa a ser associada
	 * @param codigoProjeto - projeto ao qual o profissional será associado
	 * @param cargo - cargo em que o profissional trabalha
	 * @param valorHora - valor R$ da hora do graduando
	 * @param qntHoras - quantidade de horas semanais dedicadas ao projeto
	 */
	public void associaProfissional(String cpfPessoa, int codigoProjeto, String cargo, double valorHora, int qntHoras) {

	}
	
	/**
	 * Faz a associação de um pós-graduando a um projeto
	 * @param cpfPessoa - cpf da pessoa a ser associada
	 * @param codigoProjeto - projeto ao qual o profissional será associado
	 * @param nivel - String indicando qual o nível da pós graduação do aluno, podendo ser mestrado ou doutorado
	 * @param valorHora - valor R$ da hora do graduando
	 * @param qntHoras - quantidade de horas semanais dedicadas ao projeto
	 */
	public void associaPosGraduando(String cpfPessoa, int codigoProjeto, String nivel, double valorHora, int qntHoras) {

	}

	/**
	 * remove a participação de pessoa e projeto
	 * @param cpfPessoa - CPF da pessoa a ser removida a participacao
	 * @param codigoProjeto - codigo do projeto a ser removida a participacao
	 */
	public void removeParticipacao(String cpfPessoa, int codigoProjeto) {

	}
	
	public double calculaPontucaoPorParticipacao(String cpfPessoa) {
		return 0;
	}
}
