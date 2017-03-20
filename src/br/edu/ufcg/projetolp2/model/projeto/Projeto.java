package br.edu.ufcg.projetolp2.model.projeto;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.Atributavel;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.TipoParticipacao;
import br.edu.ufcg.projetolp2.util.DateUtil;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public abstract class Projeto implements Atributavel{
	public String tipoProjeto = "Projeto";
	
	private String nome;
	private String objetivo;
	private Date dataInicio;
	private int duracaoMeses;
	private int codigo;
	private List<Custo> custos;
	private List<Participacao> participacoes;

	public Projeto(int codigo, String nome, String objetivo, String dataInicio, int duracao) throws ParseException {
		ValidateUtil.validaString(nome, "Nome nulo ou vazio");
		ValidateUtil.validaString(objetivo, "Objetivo nulo ou vazio");
		
		ValidateUtil.validaData(dataInicio);
		Date inicio;
		try{
			inicio = DateUtil.parseDate(dataInicio);
		} catch (ParseException e){
			throw new ValidacaoException("Formato de data invalido");
		}
		
		ValidateUtil.validaPositivo(duracao);
		
		this.nome = nome;
		this.objetivo = objetivo;
		this.dataInicio = inicio;
		this.duracaoMeses = duracao;
		this.codigo = codigo;
		this.custos = new ArrayList<Custo>();
		this.participacoes = new ArrayList<Participacao>();
	}

	public String getNome() {
		return this.nome;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public int getDuracao() {
		return this.duracaoMeses;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setObjetivo(String objetivo) {
		ValidateUtil.validaString(objetivo, "Objetivo nulo ou vazio");
		this.objetivo = objetivo;
	}

	public void setDataInicio(String dataInicio) {
		ValidateUtil.validaData(dataInicio);
		Date inicio;
		try{
			inicio = DateUtil.parseDate(dataInicio);
		} catch (ParseException e){
			throw new ValidacaoException("Formato de data invalido");
		}
		
		this.dataInicio = inicio;
	}
	
	public void setNome(String nome) {
		ValidateUtil.validaString(nome, "Nome nulo ou vazio");
		this.nome = nome;
	}

	public void setDuracao(int duracao) {
		ValidateUtil.validaPositivo(duracao);
		this.duracaoMeses = duracao;
	}

	public void addCusto(double valor, TipoCusto tipoCusto) {
		Custo custo = new Custo(valor, tipoCusto);
		this.custos.add(custo);
	}
	
	public String getParticipacoes() {
		StringBuilder res = new StringBuilder();
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()){
			Participacao p = it.next();
			res.append(p.getPessoa().getNome());
			
			if (it.hasNext()){
				res.append(", ");
			}
		}
		return res.toString();
	}
	
	private Participacao getParticipacao(String cpfPessoa) {
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (cpfPessoa.equals(p.getPessoa().getCpf())) {
				return p;
			}
		}
		throw new ProjetoException("Projeto nao possui participacao da pessoa indicada");
	}
	
	public void removeParticipacao(String cpfPessoa) {
		participacoes.remove(getParticipacao(cpfPessoa));		
	}
	
	public void adicionaParticipacao(Participacao participacao) {
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (participacao.getPessoa().getCpf().equals(p.getPessoa().getCpf())) {
				String prefixo = "";
				
				
				switch(participacao.getTipoParticipacao().getTipoParticipacao()) {
					case(TipoParticipacao.GRADUANDO): case(TipoParticipacao.POS_GRADUANDO):
						prefixo = "Aluno";
						break;
					case(TipoParticipacao.PROFESSOR):
						prefixo = "Professor";
						break;
					case(TipoParticipacao.PROFISSIONAL):
						prefixo = "Profissional";
				}
				
				throw new ProjetoException(prefixo+" ja esta cadastado nesse projeto");
			}
		}
		participacoes.add(participacao);
	}
	

	public String toString() {
		return codigo +": "+ nome;
	}

	@Override
	public String getInfo(String atributo){
		switch (atributo.toLowerCase()){
		case "codigo":
			return ""+getCodigo();
			
		case "data de inicio":
			return getDataInicio().toString();
			
		case "duracao":
			return ""+getDuracao();
			
		case "nome":
			return getNome();
			
		case "objetivo":
			return getObjetivo();
		
		case "participacoes":
			return getParticipacoes();
		}
		
		throw new ProjetoException(tipoProjeto + " nao posssui " + atributo);
	}
	
	@Override
	public void setInfo(String atributo, String valor) {
		switch (atributo.toLowerCase()){
		case "codigo":
			throw new ProjetoException("nao pode alterar codigo de "+tipoProjeto);
			
		case "data de inicio":
			setDataInicio(valor);
		
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Projeto other = (Projeto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
}
