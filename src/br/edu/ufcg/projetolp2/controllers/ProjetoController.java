package br.edu.ufcg.projetolp2.controllers;

import java.util.Date;
import java.util.Map;

import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class ProjetoController {

	private Map<Integer, Projeto> projetos;
	private PedFactory pedFactory;
	
	public ProjetoController() {
		// TODO Auto-generated constructor stub
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

	public String getNome(String cpf) {
		return null;
	}

	public String getObjetivo(String cpf) {
		return null;
	}

	public Date getDataInicio(String cpf) {
		return null;
	}

	public int getDuracao(String cpf) {
		return 0;
	}

	public int getCodigo(String cpf) {
		return 0;
	}

	public void editaObjetivo(int codigo, String objetivo) {

	}

	public void editaNome(int codigo, String nome) {

	}

	public void editaDuracao(int coding, int duracao) {

	}

	public void removeProjeto(int codigo) {

	}

}
