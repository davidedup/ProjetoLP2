package br.edu.ufcg.projetolp2.controllers;

import java.util.Date;

public class MainController {

	private PessoaController pessoaController;
	private ProjetoController projetoController;
	private ParticipacaoController participacaoController;
	
	public MainController () {
		// TODO Auto-generated constructor stub
	}

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

	public void adicionaParticipacao(int codigoProjeto, String cpf, Date dataInicio, int duracao, int horasSemanais, double valorHora) {
		
	}
	
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) {
		return projetoController.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
	}

	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) {
		return projetoController.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
	}

	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) {
		return projetoController.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
	}

	
	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		return projetoController.adicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);
	}

	public String getInfoProjeto(int cod, String atributo) {
		if (atributo.equalsIgnoreCase("nome")){
			return projetoController.getNome(cod);
		}else if(atributo.equalsIgnoreCase("objetivo")){
			return projetoController.getObjetivo(cod);
		}else if(atributo.equalsIgnoreCase("Data de inicio")){
			return projetoController.getDataInicio(cod);
		}else{
			return projetoController.getDuracao(cod);
		}
	}

	public void editaProjeto(int codigo, String atributo, String valor) {
		if (atributo.equalsIgnoreCase("nome")){
			projetoController.editaNome(codigo, valor);
		}else if(atributo.equalsIgnoreCase("objetivo")){
			projetoController.editaObjetivo(codigo, valor);
		}else if(atributo.equalsIgnoreCase("Data de inicio")){
			projetoController.editaDataInicio(codigo,valor);
		}else{
			projetoController.editaDuracao(codigo, Integer.parseInt(valor));
		}
	}

	public void removeProjeto(int codigo) {

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
