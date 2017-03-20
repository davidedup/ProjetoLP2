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
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoPosGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfissional;
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

	/**
	 * construtor de Projeto (abstrato)
	 * @param codigo - codigo do projeto
	 * @param nome - nome do projeto
	 * @param objetivo - objetivo do projeto
	 * @param dataInicio - data de inicio do projeto
	 * @param duracao - duracao do projeto (em meses)
	 * @throws ParseException
	 */
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
		
		ValidateUtil.validaPositivo(duracao, "Duracao invalida");
		
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
		ValidateUtil.validaPositivo(duracao, "Duracao invalida");
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
	
	/**
	 * procura (e retorna) uma participacao com uma pessoa com a participacao fornecida
	 * @param cpfPessoa - cpf da pessoa a ser procurado
	 * @return - retorna participacao com o a pessoa do cpf
	 */
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
	
	/**
	 * remove participacao com pessoa a partir do cpf fornecido
	 * @param cpfPessoa - cpf da pessoa
	 */
	public void removeParticipacao(String cpfPessoa) {
		participacoes.remove(getParticipacao(cpfPessoa));		
	}
	
	/**
	 * adiciona uma participacao, caso nao haja participacao com essa pessoa
	 * @param participacao - objeto Participacao a ser adicionado
	 */
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
	
	final public int getParticipacoesProfessor(){
		int res = 0;
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getTipoParticipacao().getClass() == ParticipacaoProfessor.class){
				res++;
			}
		}
		return res;
	}
	
	final public int getParticipacoesCoordenador(){
		int res = 0;
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getTipoParticipacao().getClass() == ParticipacaoProfessor.class){
				ParticipacaoProfessor professor = (ParticipacaoProfessor) p.getTipoParticipacao();
				if (professor.getCoordenador()){
					res++;
				}
			}
		}
		return res;
	}
	
	final public int getParticipacoesGraduando(){
		int res = 0;
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getTipoParticipacao().getClass() == ParticipacaoGraduando.class){
				res++;
			}
		}
		return res;
	}
	
	final public int getParticipacoesPosGraduando(){
		int res = 0;
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getTipoParticipacao().getClass() == ParticipacaoPosGraduando.class){
				res++;
			}
		}
		return res;
	}
	
	final public int getParticipacoesProfissional(){
		int res = 0;
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getTipoParticipacao().getClass() == ParticipacaoProfissional.class){
				res++;
			}
		}
		return res;
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
		
		throw new ProjetoException("Atributo nulo ou invalido");
	}
	
	@Override
	public void setInfo(String atributo, String valor) {
		ValidateUtil.validaString(atributo, "Atributo nulo ou invalido");
		ValidateUtil.validaString(atributo, atributo+" nulo ou vazio");
		
		switch (atributo.toLowerCase()){
		case "codigo":
			throw new ProjetoException("nao pode alterar codigo de "+tipoProjeto);
			
		case "data de inicio":
			setDataInicio(valor);
			
		case "duracao":
			ValidateUtil.validaPositivo(Integer.valueOf(valor), "Duracao invalida");
			setDuracao(Integer.valueOf(valor));
			
		case "nome":
			setNome(valor);
			
		case "objetivo":
			setObjetivo(valor);
		}
		
		throw new ProjetoException("Atributo nulo ou invalido");
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
