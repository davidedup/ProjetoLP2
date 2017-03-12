package br.edu.ufcg.projetolp2.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.util.DateUtil;

public class ProjetoController {

	private Map<Integer, Projeto> projetos;
	private PedFactory pedFactory;
	private int ultimoCodigo;
	
	public ProjetoController() {
		ultimoCodigo = 0;
		projetos = new HashMap<>();
		pedFactory = new PedFactory();
	}

	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) {
		
		Date data;
		try {
			data = DateUtil.parseDate(dataInicio);
		} catch (ParseException e) {
			throw new CpcException(e, "Ocorreu um erro: formato de data inválido");
		}
		
		Projeto projeto = new Monitoria(ultimoCodigo, nome, objetivo, data, duracao, disciplina, periodo);
		projetos.put(projeto.getCodigo(), projeto);
		ultimoCodigo++;
		
		return projeto.getCodigo();
	}

	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) {
		return 0;
	}

	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) {
		return 0;
	}

	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		Date data;
		try {
			data = DateUtil.parseDate(dataInicio);
		} catch (ParseException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: formato de data invalido");
		}
		
		Projeto projeto = new Extensao(ultimoCodigo, nome, objetivo, data, duracao, impacto);
		projetos.put(projeto.getCodigo(), projeto);
		ultimoCodigo++;
		
		return projeto.getCodigo();
	}

	public String getNome(int codigo) {
		return null;
	}

	public String getObjetivo(int codigo) {
		return null;
	}

	public Date getDataInicio(int codigo) {
		return null;
	}

	public int getDuracao(int codigo) {
		return 0;
	}

	public void editaObjetivo(int codigo, String objetivo) {

	}

	public void editaNome(int codigo, String nome) {

	}

	public void editaDuracao(int coding, int duracao) {

	}
	
	public void editaDataInicio(Date data) {

	}

	public void removeProjeto(int codigo) {

	}
	
	public Projeto getProjeto(int codigo) {
		return null;
	}

}
