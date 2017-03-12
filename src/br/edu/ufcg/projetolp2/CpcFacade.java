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
