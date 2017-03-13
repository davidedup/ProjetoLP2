package br.edu.ufcg.projetolp2;
import java.util.Date;

import br.edu.ufcg.projetolp2.controllers.MainController;

public class CpcFacade {

	private MainController controller;
	
	public CpcFacade(){
		controller = new MainController();
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
		return controller.cadastraPessoa(cpf, nome, email);
	}
	
	/**
	 * Este método edita os dados da pessoa com base no atributo passado que se deseja editar
	 * @param cpf - CPF da pessoa a ser editada
	 * @param atributo - atributo de Pessoa que se deseja editar
	 * @param valor - Novo valor que o atributo escolhido editado irá ter
	 */
	public void editaPessoa(String cpf, String atributo, String valor) {
		controller.editaPessoa(cpf, atributo, valor);
	}

	/**
	 * Este método retorna o atributo de pessoa desejado com base no valor atributo.
	 * @param cpf - CPF da pessoa que se quer a informação
	 * @param atributo - Qual o atributo de pessoa que irá ser retornardo 
	 * @return pode retornar o nome ou email, ambos String
	 */
	public String getInfoPessoa(String cpf, String atributo) {
		return controller.getInfoPessoa(cpf, atributo);
	}
	
	/**
	 * Este método remove a pessoa portadora do CPF passado
	 * @param cpf - CPF da pessoa que se deseja remover
	 */
	public void removePessoa(String cpf) {
		controller.removePessoa(cpf);
	}

	public void adicionaParticipacao(int codigoProjeto, String cpf, Date dataInicio, int duracao, int horasSemanais,
			double valorHora) {
		controller.adicionaParticipacao(codigoProjeto, cpf, dataInicio, duracao, horasSemanais, valorHora);
	}
	
	/**
	 * Adiciona ao sistema um projeto de monitoria
	 * @param nome - nome do projeto de monitoria
	 * @param disciplina - nome da disciplina da monitoria
	 * @param rendimento - porcentagem do rendimento do projeto
	 * @param objetivo - objetivo da monitoria
	 * @param periodo - periodo letivo da monitoria
	 * @param dataInicio - data de inicio do projeto
	 * @param duracao - tempo (em meses) de duracao do projeto
	 * @return
	 */
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) {
		return controller.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
	}

	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) {
		return controller.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
	}

	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) {
		return controller.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
	}

	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		return controller.adicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);
	}

	public String getInfoProjeto(int cod, String atributo) {
		return controller.getInfoProjeto(cod, atributo);
	}
	
	public int getCodigoProjeto(String nomeProjeto) {
		return controller.getCodigoProjeto(nomeProjeto);
	}

	public void editaProjeto(int codigo, String atributo, String valor) {
		controller.editaProjeto(codigo, atributo, valor);
	}

	public void removeProjeto(int codigo) {
		controller.removeProjeto(codigo);
	}

	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras) {

	}

	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras) {

	}

	public void associaProfissional(String cpfPessoa, int codigoProjeto, String cargo, double valorHora, int qntHoras) {

	}

	public void removeParticipacao(String cpfPessoa, int codigoProjeto) {

	}
}
