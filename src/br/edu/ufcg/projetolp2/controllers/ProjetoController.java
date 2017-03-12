package br.edu.ufcg.projetolp2.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.exceptions.FactoryException;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Pet;
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
			throw new CpcException(e, "Ocorreu um erro: Formato de data invalido");
		}
		
		Projeto projeto = new Monitoria(ultimoCodigo, nome, objetivo, data, duracao, disciplina, periodo);
		projetos.put(projeto.getCodigo(), projeto);
		ultimoCodigo++;
		
		return projeto.getCodigo();
	}

	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) {
		Date data;
		try {
			data = DateUtil.parseDate(dataInicio);
		} catch (ParseException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: Formato de data invalido");
		}
		
		Projeto projeto = new Pet(ultimoCodigo, nome, objetivo, data, duracao, impacto, prodTecnica, prodAcademica, patentes, rendimento);
		projetos.put(projeto.getCodigo(), projeto);
		ultimoCodigo++;
		
		return projeto.getCodigo();
	}

	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) {
	
		Projeto projeto;
		
		try {
			projeto = pedFactory.create(ultimoCodigo, nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		} catch (FactoryException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
		
		projetos.put(projeto.getCodigo(), projeto);
		ultimoCodigo++;
		
		return projeto.getCodigo();
	}

	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		Date data;
		try {
			data = DateUtil.parseDate(dataInicio);
		} catch (ParseException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: Formato de data invalido");
		}
		
		Projeto projeto = new Extensao(ultimoCodigo, nome, objetivo, data, duracao, impacto);
		projetos.put(projeto.getCodigo(), projeto);
		ultimoCodigo++;
		
		return projeto.getCodigo();
	}

	public String getNome(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		return projeto.getNome();
	}

	public String getObjetivo(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		return projeto.getObjetivo();
	}

	public Date getDataInicio(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		return projeto.getDataInicio();
	}

	public int getDuracao(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		return projeto.getDuracao();
	}

	public void editaObjetivo(int codigo, String objetivo) {
		Projeto projeto = this.getProjeto(codigo);
		projeto.setObjetivo(objetivo);
	}

	public void editaNome(int codigo, String nome) {
		Projeto projeto = this.getProjeto(codigo);
		projeto.setNome(nome);
	}

	public void editaDuracao(int codigo, int duracao) {
		Projeto projeto = this.getProjeto(codigo);
		projeto.setDuracao(duracao);
	}
	
	public void editaDataInicio(int codigo, Date data) {
		Projeto projeto = this.getProjeto(codigo);
		projeto.setDataInicio(data);
	}

	public void removeProjeto(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		projetos.remove(codigo, projeto);
	}
	
	public Projeto getProjeto(int codigo) {
		if (projetos.containsKey(codigo))
			return projetos.get(codigo);
		else
			throw new CpcException("Erro na consulta de projeto: Projeto nao encontrado");
	}

}
