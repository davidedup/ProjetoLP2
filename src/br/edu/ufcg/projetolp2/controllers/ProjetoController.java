package br.edu.ufcg.projetolp2.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.edu.ufcg.projetolp2.exceptions.FactoryException;
import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Pet;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
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
			throw new ValidacaoException(e, "Formato de data invalido");
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
			throw new ValidacaoException(e, "Formato de data invalido");
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
			throw new ValidacaoException(e, e.getMessage());
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
			throw new ValidacaoException(e, "Formato de data invalido");
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
	
	public int getImpacto(int codigo) {
		
		Projeto projeto = this.getProjeto(codigo);
		
		if (projeto instanceof Pet) {
			return ((Pet) projeto).getImpacto();
		} else if (projeto instanceof Extensao) {
			return ((Extensao) projeto).getImpacto();
		} else if (projeto instanceof Ped){
			throw new ProjetoException("P&D nao possui Impacto");
		} else {
			throw new ProjetoException("Monitoria nao possui Impacto");
		}
	}
	
	public int getProdTecnica(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		
		if (projeto instanceof Pet) {
			return ((Pet) projeto).getProducaoTecnica();
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Producao tecnica");
		} else if (projeto instanceof Ped){
			return ((Ped) projeto).getProducaoTecnica();
		} else {
			throw new ProjetoException("Monitoria nao possui Producao tecnica");
		}
	}
	
	public int getProdAcademica(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			return ((Pet) projeto).getProducaoAcademica();
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Producao academica");
		} else if (projeto instanceof Ped){
			return ((Ped) projeto).getProducaoAcademica();
		} else {
			throw new ProjetoException("Monitoria nao possui Producao academica");
		}
	}
	
	public int getPatentes(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			return ((Pet) projeto).getPatentes();
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Ped){
			return ((Ped) projeto).getPatentes();
		} else {
			throw new ProjetoException("Monitoria nao possui Patentes");
		}
	}
	
	public int getRendimento(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			return ((Pet) projeto).getPatentes();
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Ped){
			return ((Ped) projeto).getPatentes();
		} else {
			throw new ProjetoException("Monitoria nao possui Patentes");
		}
	}
	
	public String getDisciplina(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Ped){
			throw new ProjetoException("Extensao nao possui Patentes");
		} else {
			return ((Monitoria) projeto).getDisciplina();
		}
	}
	
	public String getPeriodo(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Ped){
			throw new ProjetoException("Extensao nao possui Patentes");
		} else {
			return ((Monitoria) projeto).getPeriodo();
		}
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
	
	public void editaImpacto(int codigo, int impacto) {
		
		Projeto projeto = this.getProjeto(codigo);
		
		if (projeto instanceof Pet) {
			((Pet) projeto).setImpacto(impacto);
		} else if (projeto instanceof Extensao) {
			((Extensao) projeto).setImpacto(impacto);
		} else if (projeto instanceof Ped){
			throw new ProjetoException("P&D nao possui Impacto");
		} else {
			throw new ProjetoException("Monitoria nao possui Impacto");
		}
	}
	
	public void setProdTecnica(int codigo, int prodTecnica) {
		Projeto projeto = this.getProjeto(codigo);
		
		if (projeto instanceof Pet) {
			((Pet) projeto).setProducaoTecnica(prodTecnica);
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Producao tecnica");
		} else if (projeto instanceof Ped) {
			((Ped) projeto).setProducaoTecnica(prodTecnica);
		} else {
			throw new ProjetoException("Monitoria nao possui Producao tecnica");
		}
	}
	
	public void setProdAcademica(int codigo, int prodAcademica) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			((Pet) projeto).setProducaoAcademica(prodAcademica);
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Producao academica");
		} else if (projeto instanceof Ped){
			((Ped) projeto).setProducaoAcademica(prodAcademica);
		} else {
			throw new ProjetoException("Monitoria nao possui Producao academica");
		}
	}
	
	public void setPatentes(int codigo, int patentes) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			((Pet) projeto).setPatentes(patentes);
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Ped){
			((Ped) projeto).setPatentes(patentes);
		} else {
			throw new ProjetoException("Monitoria nao possui Patentes");
		}
	}
	
	public void setRendimento(int codigo, int rendimento) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			((Pet) projeto).setPatentes(rendimento);
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Ped){
			((Ped) projeto).setPatentes(rendimento);
		} else {
			throw new ProjetoException("Monitoria nao possui Patentes");
		}
	}
	
	public void setDisciplina(int codigo, String disciplina) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Ped){
			throw new ProjetoException("Extensao nao possui Patentes");
		} else {
			((Monitoria) projeto).setDisciplina(disciplina);
		}
	}
	
	public void setPeriodo(int codigo, String periodo) {
		Projeto projeto = this.getProjeto(codigo);
		if (projeto instanceof Pet) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Extensao) {
			throw new ProjetoException("Extensao nao possui Patentes");
		} else if (projeto instanceof Ped){
			throw new ProjetoException("Extensao nao possui Patentes");
		} else {
			((Monitoria) projeto).setPeriodo(periodo);
		}
	}

	public void removeProjeto(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		projetos.remove(codigo, projeto);
	}
	
	public Projeto getProjeto(int codigo) {
		if (projetos.containsKey(codigo))
			return projetos.get(codigo);
		else
			throw new ProjetoException("Projeto nao encontrado");
	}

}
