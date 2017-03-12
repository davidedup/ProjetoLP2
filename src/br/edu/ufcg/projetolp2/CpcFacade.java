package br.edu.ufcg.projetolp2;
import br.edu.ufcg.projetolp2.controllers.MainController;

public class CpcFacade {

	private MainController controller;

	public void iniciaSistema() {

	}

	public void fechaSistema() {

	}

	public String cadastraPessoa(String cpf, String nome, String email) {
		return null;
	}

	public void editaPessoa(String cpf, String atributo, String valor) {

	}

	public String getInfoPessoa(String cpf, String atributo) {
		return null;
	}

	public void removePessoa(String cpf) {

	}

	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) {
		return 0;
	}

	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) {
		return 0;
	}

	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) {
		return 0;
	}

	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		return 0;
	}

	public String getInfoProjeto(int cod, String atributo) {
		return null;
	}

	public void editaProjeto(int codigo, String atributo, int valor) {

	}

	public void removeProjeto(int codigo) {

	}

	/**
	 * Faz a associação de um professor a um projeto
	 * @param cpfPessoa - cpf da pessoa a ser associada
	 * @param codigoProjeto - projeto ao qual o professor será associado
	 * @param coordenador - Flag para saber se é um professor coordenador
	 * @param valorHora - valor R$ da hora do professor
	 * @param qntHoras -  quantidade de horas semanais dedicada ao projeto
	 */
	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras) {
		controller.associaProfessor(cpfPessoa, codigoProjeto, coordenador, valorHora, qntHoras);
	}

	/**
	 * Faz a associação de um graduando a um projeto
	 * @param cpfPessoa - cpf da pessoa a ser associada
	 * @param codigoProjeto - projeto ao qual o graduando será associado
	 * @param valorHora - valor R$ da hora do graduando
	 * @param qntHoras -  quantidade de horas semanais dedicadas ao projeto
	 */
	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras) {
		controller.associaGraduando(cpfPessoa, codigoProjeto, valorHora, qntHoras);
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
		controller.associaProfissional(cpfPessoa, codigoProjeto, cargo, valorHora, qntHoras);
	}

	/**
	 * remove a participaçao de pessoa e projeto
	 * @param cpfPessoa - CPF da pessoa a ser removida a participacao
	 * @param codigoProjeto - codigo do projeto a ser removida a participacao
	 */
	public void removeParticipacao(String cpfPessoa, int codigoProjeto) {
		controller.removeParticipacao(cpfPessoa, codigoProjeto);
	}

}
