package br.edu.ufcg.projetolp2.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.projetolp2.exceptions.*;
import br.edu.ufcg.projetolp2.model.projeto.*;
import br.edu.ufcg.projetolp2.model.projeto.tipos.*;
import br.edu.ufcg.projetolp2.util.*;

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
		if (StringUtil.isStringNula(nome) || StringUtil.isStringVazia(nome)){
			throw new ValidacaoException("Erro no cadastro de projeto: Nome nulo ou vazio");
		}
		
		if (StringUtil.isStringNula(disciplina) || StringUtil.isStringVazia(disciplina)){
			throw new ValidacaoException("Erro no cadastro de projeto: Disciplina nulo ou vazio");
		}
		
		if (StringUtil.isStringNula(objetivo) || StringUtil.isStringVazia(objetivo)){
			throw new ValidacaoException("Erro no cadastro de projeto: Objetivo nulo ou vazio");
		}
		
		if (!NumbersUtil.isNaturalPositive(duracao)){
			throw new ValidacaoException("Erro no cadastro de projeto: Duracao invalida");
		}
		
		if (!NumbersUtil.isNatural(rendimento)){
			throw new ValidacaoException("Erro no cadastro de projeto: Rendimento invalido");
		}
		
		
		Date data;
		try {
			data = DateUtil.parseDate(dataInicio);
		} catch (ParseException e) {
			throw new ValidacaoException(e, "Formato de data invalido");
		}
		
		Projeto projeto = new Monitoria(ultimoCodigo, nome, objetivo, data, duracao, disciplina, periodo);
		projetos.put(projeto.getCodigo(), projeto);
		ultimoCodigo++;
		
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
		if (StringUtil.isStringNula(nome) || StringUtil.isStringVazia(nome)){
			throw new ValidacaoException("Erro no cadastro de projeto: Nome nulo ou vazio");
		}
		
		if (StringUtil.isStringNula(objetivo) || StringUtil.isStringVazia(objetivo)){
			throw new ValidacaoException("Erro no cadastro de projeto: Objetivo nulo ou vazio");
		}
		
		if (!NumbersUtil.isNatural(rendimento)){
			throw new ValidacaoException("Erro no cadastro de projeto: Rendimento invalido");
		}
		
		if (!NumbersUtil.isNatural(prodTecnica)){
			throw new ValidacaoException("Erro no cadastro de projeto: Numero de producoes tecnicas invalido");
		}
		if (!NumbersUtil.isNatural(prodAcademica)){
			throw new ValidacaoException("Erro no cadastro de projeto: Numero de producoes academicas invalido");
		}
		if (!NumbersUtil.isNatural(patentes)){
			throw new ValidacaoException("Erro no cadastro de projeto: Numero de patentes invalido");
		}
		
		
		Date data;
		try {
			data = DateUtil.parseDate(dataInicio);
		} catch (ParseException e) {
			throw new ValidacaoException(e, "Formato de data invalido");
		}
		
		Projeto projeto = new Pet(ultimoCodigo, nome, objetivo, data, duracao, impacto, prodTecnica, prodAcademica, patentes, rendimento);
		projetos.put(projeto.getCodigo(), projeto);
		ultimoCodigo++;
		
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
		if (StringUtil.isStringNula(nome) || StringUtil.isStringVazia(nome)){
			throw new ValidacaoException("Nome nulo ou vazio");
		}
		
		if (StringUtil.isStringNula(objetivo) || StringUtil.isStringVazia(objetivo)){
			throw new ValidacaoException("Objetivo nulo ou vazio");
		}
		
		if (!NumbersUtil.isNaturalPositive(duracao)){
			throw new ValidacaoException("Duracao invalida");
		}
		
		if (!NumbersUtil.isNatural(prodTecnica)){
			throw new ValidacaoException("Numero de producoes tecnicas invalido");
		}
		if (!NumbersUtil.isNatural(prodAcademica)){
			throw new ValidacaoException("Numero de producoes academicas invalido");
		}
		if (!NumbersUtil.isNatural(patentes)){
			throw new ValidacaoException("Numero de patentes invalido");
		}
	
		Projeto projeto;
		
		try {
			projeto = pedFactory.create(ultimoCodigo, nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		} catch (FactoryException e) {
			throw new ValidacaoException(e, e.getMessage());
		}
		
		projetos.put(projeto.getCodigo(), projeto);
		ultimoCodigo++;
		
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
		if (StringUtil.isStringNula(nome) || StringUtil.isStringVazia(nome)){
			throw new ValidacaoException("Erro no cadastro de projeto: Nome nulo ou vazio");
		}
		
		if (StringUtil.isStringNula(objetivo) || StringUtil.isStringVazia(objetivo)){
			throw new ValidacaoException("Erro no cadastro de projeto: Objetivo nulo ou vazio");
		}
		
		if (!NumbersUtil.isNaturalPositive(duracao)){
			throw new ValidacaoException("Erro no cadastro de projeto: Duracao invalida");
		}
		
		Date data;
		try {
			data = DateUtil.parseDate(dataInicio);
		} catch (ParseException e) {
			throw new ValidacaoException(e, "Formato de data invalido");
		}
		
		Projeto projeto = new Extensao(ultimoCodigo, nome, objetivo, data, duracao, impacto);
		projetos.put(projeto.getCodigo(), projeto);
		ultimoCodigo++;
		
		return projeto.getCodigo();
	}

	/**
	 * retorna o nome do projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 * @return - nome do projeto solicitado
	 */
	public String getNome(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		return projeto.getNome();
	}

	/**
	 * retorna o objetivo do projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 * @return - objetivo do projeto solicitado
	 */
	public String getObjetivo(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		return projeto.getObjetivo();
	}

	/**
	 * retorna a data de inicio do projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 * @return - data do projeto solicitado
	 */
	public Date getDataInicio(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		return projeto.getDataInicio();
	}

	/**
	 * retorna a duracao (em meses) do projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 * @return - tempo de duracao (em meses) do projeto solicitado
	 */
	public int getDuracao(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		return projeto.getDuracao();
	}
	
	/**
	 * retorna o impacto do projeto, dado seu codigo (apenas para projetos de Pet e Extensao)
	 * @param codigo - codigo do projeto
	 * @return - impacto do projeto (varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil))
	 */
	public int getImpacto(int codigo) {
		
		Projeto projeto = this.getProjeto(codigo);
		
		if (projeto instanceof Pet) {
			return ((Pet) projeto).getImpacto();
		} else if (projeto instanceof Extensao) {
			return ((Extensao) projeto).getImpacto();
		} else if (projeto instanceof Ped){
			throw new ProjetoException("Erro na consulta de projeto: P&D nao possui Impacto");
		} else {
			throw new ProjetoException("Erro na consulta de projeto: Monitoria nao possui Impacto");
		}
	}
	
	/**
	 * retorna o numero de producoes tecnicas do projeto, dado seu codigo (apenas para projetos de Pet e P&D)
	 * @param codigo - codigo do projeto
	 * @return - total de producoes tecnicas do projeto
	 */
	public int getProdTecnica(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		
		if (projeto instanceof Pet) {
			return ((Pet) projeto).getProducaoTecnica();
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Producao tecnica");
		} else if (projeto instanceof Ped){
			return ((Ped) projeto).getProducaoTecnica();
		} else {
			throw new ProjetoException("Erro na consulta de projeto: Monitoria nao possui Producao tecnica");
		}
	}
	
	/**
	 * retorna a quantidade de producoes academicas do projeto, dado seu codigo (apenas para projetos Pet e P&D)
	 * @param codigo - codigo do projeto
	 * @return - total de producoes academicas do projeto
	 */
	public int getProdAcademica(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			return ((Pet) projeto).getProducaoAcademica();
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Erro na consulta de projeto: Extensao nao possui Producao academica");
		} else if (projeto instanceof Ped){
			return ((Ped) projeto).getProducaoAcademica();
		} else {
			throw new ProjetoException("Erro na consulta de projeto: Monitoria nao possui Producao academica");
		}
	}
	
	/**
	 * retorna a quantidade de patentes do projeto, dado seu codigo (apenas para projetos Pet e P&D)
	 * @param codigo - codigo do projeto
	 * @return - total de patentes do projeto
	 */
	public int getPatentes(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			return ((Pet) projeto).getPatentes();
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Erro na consulta de projeto: Extensao nao possui Patentes");
		} else if (projeto instanceof Ped){
			return ((Ped) projeto).getPatentes();
		} else {
			throw new ProjetoException("Erro na consulta de projeto: Monitoria nao possui Patentes");
		}
	}
	
	/**
	 * retorna o percentual de rendimento do projeto (apenas para Pet e P&D)
	 * @param codigo - codigo do projeto
	 * @return - percentual de rendimento do projeto
	 */
	public int getRendimento(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			return ((Pet) projeto).getPatentes();
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Erro na consulta de projeto: Extensao nao possui Rendimento");
		} else if (projeto instanceof Ped){
			return ((Ped) projeto).getPatentes();
		} else {
			throw new ProjetoException("Erro na consulta de projeto: Monitoria nao possui Rendimento");
		}
	}
	
	/**
	 * retorna o nome da disciplina associada ao projeto (apenas para monitoria)
	 * @param codigo - codigo do projeto
	 * @return - nome da disciplina
	 */
	public String getDisciplina(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			throw new ProjetoException("Erro na consulta de projeto: Pet nao possui Disciplina");
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Erro na consulta de projeto: Extensao nao possui Disciplina");
		} else if (projeto instanceof Ped){
			throw new ProjetoException("Erro na consulta de projeto: Ped nao possui Disciplina");
		} else {
			return ((Monitoria) projeto).getDisciplina();
		}
	}
	
	/**
	 * retorna o periodo letivo que ocorreu o projeto de monitoria (apenas para monitoria)
	 * @param codigo - codigo do projeto
	 * @return - periodo letivo da monitoria
	 */
	public String getPeriodo(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			throw new ProjetoException("Erro na consulta de projeto: Pet nao possui Periodo");
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Erro na consulta de projeto: Extensao nao possui Periodo");
		} else if (projeto instanceof Ped){
			throw new ProjetoException("Erro na consulta de projeto: Ped nao possui Periodo");
		} else {
			return ((Monitoria) projeto).getPeriodo();
		}
	}

	/**
	 * edita o objetivo do projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 * @param objetivo - novo objetivo do projeto
	 */
	public void editaObjetivo(int codigo, String objetivo) {
		if (StringUtil.isStringNula(objetivo) || StringUtil.isStringVazia(objetivo)){
			throw new ValidacaoException("Erro na atualizacao de projeto: Objetivo nulo ou vazio");
		}
		
		Projeto projeto = this.getProjeto(codigo);
		projeto.setObjetivo(objetivo);
	}

	/**
	 * edita o nome do projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 * @param nome - novo nome do projeto
	 */
	public void editaNome(int codigo, String nome) {
		if (StringUtil.isStringNula(nome) || StringUtil.isStringVazia(nome)){
			throw new ValidacaoException("Erro na atualizacao de projeto: Nome nulo ou vazio");
		}
		
		Projeto projeto = this.getProjeto(codigo);
		projeto.setNome(nome);
	}

	/**
	 * edita a duracao (em meses) do projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 * @param duracao - nova duracao (em meses) do projeto
	 */
	public void editaDuracao(int codigo, int duracao) {
		if (!NumbersUtil.isNaturalPositive(duracao)){
			throw new ValidacaoException("Erro na atualizacao de projeto: Duracao nulo ou vazio");
		}
		
		Projeto projeto = this.getProjeto(codigo);
		projeto.setDuracao(duracao);
	}
	
	/**
	 * edita a data de inicio do projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 * @param data - data do projeto
	 */
	public void editaDataInicio(int codigo, Date data) {
		Projeto projeto = this.getProjeto(codigo);
		projeto.setDataInicio(data);
	}
	
	/**
	 * edita o impacto do projeto, dado seu codigo (apenas para Pet e Extensao)
	 * @param codigo - codigo do projeto
	 * @param impacto - novo impacto do projeto -> varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil)
	 */
	public void editaImpacto(int codigo, int impacto) {
		if (impacto <= 0 || impacto > 6){
			throw new ValidacaoException("Erro na atualizacao de projeto: Valor de impacto invalido");
		}
		
		Projeto projeto = this.getProjeto(codigo);
		
		if (projeto instanceof Pet) {
			((Pet) projeto).setImpacto(impacto);
		} else if (projeto instanceof Extensao) {
			((Extensao) projeto).setImpacto(impacto);
		} else if (projeto instanceof Ped){
			throw new ProjetoException("Erro na atualizacao de projeto: P&D nao possui Impacto");
		} else {
			throw new ProjetoException("Erro na atualizacao de projeto: Monitoria nao possui Impacto");
		}
	}
	
	
	/**
	 * atualiza o total de producoes tecnicas do projeto, dado seu codigo (apenas para Pet e P&D)
	 * @param codigo - codigo do projeto
	 * @param prodTecnica - novo numero de producoes tecnicas
	 */
	public void setProdTecnica(int codigo, int prodTecnica) {
		if (!NumbersUtil.isNatural(prodTecnica)){
			throw new ValidacaoException("Erro na atualizacao de projeto: Valor de producao tecnica invalido");
		}
		
		Projeto projeto = this.getProjeto(codigo);
		
		if (projeto instanceof Pet) {
			((Pet) projeto).setProducaoTecnica(prodTecnica);
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Erro na atualizacao de projeto: Extensao nao possui Producao tecnica");
		} else if (projeto instanceof Ped) {
			((Ped) projeto).setProducaoTecnica(prodTecnica);
		} else {
			throw new ProjetoException("Erro na atualizacao de projeto: Monitoria nao possui Producao tecnica");
		}
	}
	
	/**
	 * atualiza o total de producoes academicas do projeto, dado seu codigo (apenas para Pet e P&D)
	 * @param codigo - codigo do projeto
	 * @param prodAcademica - novo numero de producoes academicas
	 */
	public void setProdAcademica(int codigo, int prodAcademica) {
		if (!NumbersUtil.isNatural(prodAcademica)){
			throw new ValidacaoException("Erro na atualizacao de projeto: Valor de producao academica invalido");
		}
		
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			((Pet) projeto).setProducaoAcademica(prodAcademica);
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Producao academica");
		} else if (projeto instanceof Ped){
			((Ped) projeto).setProducaoAcademica(prodAcademica);
		} else {
			throw new ProjetoException("Erro na atualizacao de projeto: Monitoria nao possui Producao academica");
		}
	}
	
	/**
	 * atualiza o total de patentes do projeto, dado seu codigo (apenas para Pet e P&D)
	 * @param codigo - codigo do projeto
	 * @param patentes - novo numero de patentes
	 */
	public void setPatentes(int codigo, int patentes) {
		if (!NumbersUtil.isNatural(patentes)){
			throw new ValidacaoException("Erro na atualizacao de projeto: Valor de patentes invalido");
		}
		
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			((Pet) projeto).setPatentes(patentes);
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Erro na atualizacao de projeto: Extensao nao possui Patentes");
		} else if (projeto instanceof Ped){
			((Ped) projeto).setPatentes(patentes);
		} else {
			throw new ProjetoException("Erro na atualizacao de projeto: Monitoria nao possui Patentes");
		}
	}
	
	/**
	 * atualiza o percentual de rendimento do projeto, dado seu codigo (apenas para Pet e P&D)
	 * @param codigo - codigo do projeto
	 * @param rendimento - novo numero de patentes
	 */
	public void setRendimento(int codigo, int rendimento) {
		if (rendimento < 0 || rendimento > 100){
			throw new ValidacaoException("Erro na atualizacao de projeto: Valor de rendimento invalido");
		}
		
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			((Pet) projeto).setPatentes(rendimento);
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Erro na atualizacao de projeto: Extensao nao possui Rendimento");
		} else if (projeto instanceof Ped){
			((Ped) projeto).setPatentes(rendimento);
		} else {
			throw new ProjetoException("Erro na atualizacao de projeto: Monitoria nao possui Rendimento");
		}
	}
	
	/**
	 * atualiza a disciplina do projeto de monitoria (apenas para Monitoria)
	 * @param codigo - codigo do projeto
	 * @param disciplina - nova disciplina associada a monitoria
	 */
	public void setDisciplina(int codigo, String disciplina) {
		if (StringUtil.isStringNula(disciplina) || StringUtil.isStringVazia(disciplina)){
			throw new ValidacaoException("Erro na atualizacao de projeto: Disciplina nulo ou vazio");
		}
		
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			throw new ProjetoException("Erro na atualizacao de projeto: Pet nao possui Disciplina");
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Erro na atualizacao de projeto: Extensao nao possui Disciplina");
		} else if (projeto instanceof Ped){
			throw new ProjetoException("Erro na atualizacao de projeto: Ped nao possui Disciplina");
		} else {
			((Monitoria) projeto).setDisciplina(disciplina);
		}
	}
	
	/**
	 * atualiza o periodo letivo do projeto de monitoria (apenas para Monitoria)
	 * @param codigo - codigo do projeto
	 * @param periodo - novo periodo letivo do projeto
	 */
	public void setPeriodo(int codigo, String periodo) {
		if (StringUtil.isStringNula(periodo) || StringUtil.isStringVazia(periodo)){
			throw new ValidacaoException("Erro na atualizacao de projeto: Erro na atualizacao de projeto: Periodo nulo ou vazio");
		}
		
		if (Integer.valueOf(periodo) < 0) {
			throw new ValidacaoException("Erro na atualizacao de projeto: Erro na atualizacao de projeto: Valor de periodo invalido");
		}
		
		
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			throw new ProjetoException("Erro na atualizacao de projeto: Pet nao possui Periodo");
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Erro na atualizacao de projeto: Extensao nao possui Periodo");
		} else if (projeto instanceof Ped){
			throw new ProjetoException("Erro na atualizacao de projeto: Ped nao possui Periodo");
		} else {
			((Monitoria) projeto).setPeriodo(periodo);
		}
	}

	/**
	 * remove o projeto, dado seu codigo
	 * @param codigo - codigo do projeto
	 */
	public void removeProjeto(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		projetos.remove(codigo, projeto);
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
