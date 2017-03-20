package br.edu.ufcg.projetolp2.controllers;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.exceptions.FactoryException;
import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Pet;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.util.DateUtil;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public class ProjetoController {

	private Map<Integer, Projeto> projetos;
	private PedFactory pedFactory;
	private int ultimoCodigo;
	
	public ProjetoController() {
		ultimoCodigo = 0;
		projetos = new HashMap<Integer, Projeto>();
		pedFactory = new PedFactory();
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
		
		try {
			ValidateUtil.validaString(nome, "Nome nulo ou vazio");
			ValidateUtil.validaString(disciplina, "Disciplina nula ou vazia");
			ValidateUtil.validaString(objetivo, "Objetivo nulo ou vazio");
			ValidateUtil.validaString(periodo, "Periodo nulo ou vazio");
			ValidateUtil.validaPositivo(duracao);
			ValidateUtil.validaRendimento(rendimento);
			ValidateUtil.validaData(dataInicio);
		} catch (ValidacaoException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
		
		Projeto projeto = null;
			
		try {
			projeto = new Monitoria(ultimoCodigo++, nome, objetivo, DateUtil.parseDate(dataInicio), duracao, disciplina, periodo);
		} catch (ParseException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
		
		projetos.put(projeto.getCodigo(), projeto);
		
		return projeto.getCodigo();
	}
	
	/**
	 *  Cria um projeto do tipo PET e retorna seu codigo
	 * @param nome - nome do projeto PET
	 * @param objetivo - descricao do objetivo do projeto PET
	 * @param impacto - varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil)
	 * @param rendimento - rendimento que varia de 0-100%
	 * @param prodTecnica - quatidade de producoes tecnicas
	 * @param prodAcademica - quantidade de procucoes academicas
	 * @param patentes - quantidades de patentes
	 * @param dataInicio - data em que o projeto comecou
	 * @param duracao - duracoa em meses do projeto
	 * @return - o codigo do projeto adicionado
	 */
	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) {
		
		try {
			ValidateUtil.validaString(nome, "Nome nulo ou vazio");
			ValidateUtil.validaString(objetivo, "Objetivo nulo ou vazio");
			ValidateUtil.validaImpacto(impacto);
			ValidateUtil.validaRendimento(rendimento);
			ValidateUtil.validaPositivo(prodAcademica);
			ValidateUtil.validaPositivo(prodTecnica);
			ValidateUtil.validaPositivo(patentes);
			ValidateUtil.validaData(dataInicio);
			ValidateUtil.validaPositivo(duracao);
		} catch (ValidacaoException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
		
		Projeto projeto = null;
			
		try {
			projeto = new Pet(ultimoCodigo++, nome, objetivo, DateUtil.parseDate(dataInicio), duracao, impacto, prodTecnica, prodAcademica, patentes, rendimento);
		} catch (ParseException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
		
		projetos.put(projeto.getCodigo(), projeto);
		
		return projeto.getCodigo();
	}

	/**
	 * Cria um projeto do tipo P&D e retorna seu codigo
	 * @param nome do projeto do tipo P&D
	 * @param categoria - Determina a categoria do projeto Cooperacao, PIBIC,PIBITI ou PIVIC
	 * @param prodTecnica - quatidade de producoes tecnicas
	 * @param prodAcademica - quantidade de procucoes academicas
	 * @param patentes - quantidades de patentes
	 * @param objetivo -  descreve o objetivo do projeto
	 * @param dataInicio - data em que o projeto comecou
	 * @param duracao - duracao em meses do projeto
	 * @return - o codigo do projeto adicionado
	 */
	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) {
		
		try {
			ValidateUtil.validaString(nome, "Nome nulo ou vazio");
			ValidateUtil.validaString(objetivo, "Objetivo nulo ou vazio");
			ValidateUtil.validaString(categoria,  "Categoria nula ou vazia");
			ValidateUtil.validaPositivo(prodAcademica);
			ValidateUtil.validaPositivo(prodTecnica);
			ValidateUtil.validaPositivo(patentes);
			ValidateUtil.validaData(dataInicio);
			ValidateUtil.validaPositivo(duracao);
		} catch (ValidacaoException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
		
		Projeto projeto = null;
			
		try {
			projeto = pedFactory.create(ultimoCodigo++, nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		} catch (FactoryException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
		
		projetos.put(projeto.getCodigo(), projeto);
		
		return projeto.getCodigo();
	}

	
	/**
	 * Cria um projeto do tipo extens�o e retorna seu codigo
	 * @param nome - nome do projeto de exens�o
	 * @param objetivo - descricao do obejtivo do projeto
	 * @param impacto - varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil)
	 * @param dataInicio - data em que o projeto come�ou
	 * @param duracao -duracao em meses do projeto
	 * @return - codigo do projeto adicionado
	 */
	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		
		try {
			ValidateUtil.validaString(nome, "Nome nulo ou vazio");
			ValidateUtil.validaString(objetivo, "Objetivo nulo ou vazio");
			ValidateUtil.validaImpacto(impacto);
			ValidateUtil.validaData(dataInicio);
			ValidateUtil.validaPositivo(duracao);
		} catch (ValidacaoException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
		
		Projeto projeto = null;
			
		try {
			projeto = new Extensao(ultimoCodigo++, nome, objetivo, DateUtil.parseDate(dataInicio), duracao, impacto);
		} catch (ParseException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
		
		projetos.put(projeto.getCodigo(), projeto);
		
		return projeto.getCodigo();
	}

	/**
	 * remove o projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 */
	public void removeProjeto(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		projetos.remove(codigo, projeto);
	}
	
	public String getInfoProjeto (int codigo, String atributo) {
		
		try {
			ValidateUtil.validaString(atributo, "Nome nulo ou vazio");
		} catch (ValidacaoException e) {
			throw new CpcException(e, "Erro na consulta de projeto: " + e.getMessage());
		}
		
		Projeto projeto = this.getProjeto(codigo);
		
		try {
			return projeto.getInfo(atributo);
		} catch (Exception e) {
			throw new CpcException(e, "Erro na consulta de projeto: " + e.getMessage());
		}
	}
	
	public void editaProjeto (int codigo, String atributo, String valor) {
		//TODO
	}
	
	public void removeParticipacao(String cpfPessoa, int codProjeto) {
		//TODO
	}
	
	public void removeParticipacao(String cpfPessoa) {
		//TODO
	}
	
	public void adicionaParticipacao(Participacao participacao) {
		//TODO
	}
	
	public int getCodigoProjeto(String nome) {
		return 0;
		//TODO
	}
	
	/**
	 * recupera o projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 * @return - objeto Projeto requisitado
	 */
	public Projeto getProjeto(int codigo) {
		if (projetos.containsKey(codigo))
			return projetos.get(codigo);
		else
			throw new ProjetoException("Erro na consulta de projeto: Projeto nao encontrado");
	}

	public Projeto getProjeto(String nomeProjeto) {
		Set<Integer> codigos = projetos.keySet();
		for (Integer codigo : codigos) {
			Projeto projeto = projetos.get(codigo);
			if (projeto.getNome().equalsIgnoreCase(nomeProjeto))
				return projeto;
		}
		throw new ProjetoException("Erro na consulta de projeto: Projeto nao encontrado");
	}

}
