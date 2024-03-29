package br.edu.ufcg.projetolp2.model.projeto;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.util.DateUtil;
import br.edu.ufcg.projetolp2.util.IO;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public abstract class Projeto implements Atributavel, Serializable, Comparable<Projeto> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * 
	 * @param codigo
	 *            - codigo do projeto
	 * @param nome
	 *            - nome do projeto
	 * @param objetivo
	 *            - objetivo do projeto
	 * @param dataInicio
	 *            - data de inicio do projeto
	 * @param duracao
	 *            - duracao do projeto (em meses)
	 * @throws ParseException
	 */
	public Projeto(int codigo, String nome, String objetivo, String dataInicio, int duracao) throws ParseException {
		setNome(nome);
		setObjetivo(objetivo);
		setDataInicio(dataInicio);
		setDuracao(duracao);

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

	public List<Custo> getCustos() {
		return custos;
	}

	public void setObjetivo(String objetivo) {
		ValidateUtil.validaString(objetivo, "Objetivo nulo ou vazio");
		this.objetivo = objetivo;
	}

	public void setDataInicio(String dataInicio) {
		ValidateUtil.validaData(dataInicio);
		Date inicio;
		try {
			inicio = DateUtil.parseDate(dataInicio);
		} catch (ParseException e) {
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
		
		//StringBuilder res = new StringBuilder();
		List<String> res = new ArrayList<String>();
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = it.next();
			res.add(p.getPessoa().getNome());
		}
		
		Collections.sort(res);
		return String.join(", ", res);
	}

	/**
	 * procura (e retorna) uma participacao com uma pessoa com a participacao
	 * fornecida
	 * 
	 * @param cpfPessoa
	 *            - cpf da pessoa a ser procurado
	 * @return - retorna participacao com o a pessoa do cpf
	 */
	private Participacao getParticipacao(String cpfPessoa) {
		ValidateUtil.validaCpf(cpfPessoa);
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
	 * 
	 * @param cpfPessoa
	 *            - cpf da pessoa
	 */
	public void removeParticipacao(String cpfPessoa) {
		participacoes.remove(getParticipacao(cpfPessoa));
	}

	/**
	 * adiciona uma participacao, caso nao haja participacao com essa pessoa
	 * 
	 * @param participacao
	 *            - objeto Participacao a ser adicionado
	 */
	public void adicionaParticipacao(Participacao participacao) {
		Iterator<Participacao> it = participacoes.iterator();
		
		
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (participacao.getPessoa().getCpf().equals(p.getPessoa().getCpf())) {
				String prefixo = "";
				
				if (participacao.getClass() == ParticipacaoGraduando.class){
					prefixo = "Aluno";
				} else if (participacao.getClass() == ParticipacaoPosGraduando.class){
					prefixo = "Aluno";
				} else if (participacao.getClass() == ParticipacaoProfessor.class){
					prefixo = "Professor";
				} else if (participacao.getClass() == ParticipacaoProfissional.class){
					prefixo = "Profissional";
				}
				
				throw new ProjetoException(prefixo + " ja esta cadastrado nesse projeto");
			}
		}
		
		participacoes.add(participacao);
	}

	/**
	 * retorna a quantidade de participacoes de professor no projeto
	 * 
	 * @return - quantidade de professores engajados
	 */
	final public int getTotalParticipacoesProfessor() {
		int res = 0;
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getClass() == ParticipacaoProfessor.class) {
				res++;
			}
		}
		return res;
	}

	/**
	 * retorna a quantidade de participacoes de professor coordenador no projeto
	 * 
	 * @return - quantidade de professores coordenadores engajados
	 */
	final public int getTotalParticipacoesCoordenador() {
		int res = 0;
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getClass() == ParticipacaoProfessor.class) {
				ParticipacaoProfessor professor = (ParticipacaoProfessor) p;
				if (professor.getCoordenador()) {
					res++;
				}
			}
		}
		return res;
	}

	/**
	 * retorna a quantidade de participacoes de aluno de graduacao no projeto
	 * 
	 * @return - quantidade de graduandos engajados
	 */
	final public int getTotalParticipacoesGraduando() {
		int res = 0;
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getClass() == ParticipacaoGraduando.class) {
				res++;
			}
		}
		return res;
	}

	/**
	 * retorna a quantidade de participacoes de alunos de pos-graduacao no
	 * projeto
	 * 
	 * @return - quantidade de pos-graduandos engajados
	 */
	final public int getTotalParticipacoesPosGraduando() {
		int res = 0;
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getClass() == ParticipacaoPosGraduando.class) {
				res++;
			}
		}
		return res;
	}

	/**
	 * retorna a quantidade de participacoes de profissional no projeto
	 * 
	 * @return - quantidade de profissionais engajados
	 */
	final public int getTotalParticipacoesProfissional() {
		int res = 0;
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getClass() == ParticipacaoProfissional.class) {
				res++;
			}
		}
		return res;
	}

	/**
	 * retorna a quantidade de pessoas que estao associadas no projeto
	 * 
	 * @return - quantidade de participacoes registradas
	 */
	final public int getTotalParticipacoes() {
		return participacoes.size();
	}

	/**
	 * Calcula o valor da bolsa da participacao relacionada ao cpf fornecido
	 * 
	 * @param cpf
	 *            - cpf do bolsista
	 * @return - valor total da bolsa para o bolsista solicitado
	 */
	public double calculaValorBolsa(Participacao p) {
		return p.calculaValorBolsa();
	}

	@Override
	public String getInfo(String atributo) {
		switch (atributo.toLowerCase()) {
		case "codigo":
			return "" + getCodigo();

		case "data de inicio":
			return DateUtil.formatDate(getDataInicio(), "dd/MM/yyyy");

		case "duracao":
			return "" + getDuracao();

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
		ValidateUtil.validaString(atributo, atributo + " nulo ou vazio");

		switch (atributo.toLowerCase()) {
		case "codigo":
			throw new ProjetoException("nao pode alterar codigo de " + tipoProjeto);
		case "data de inicio":
			setDataInicio(valor);
			break;
		case "duracao":
			ValidateUtil.validaPositivo(Integer.valueOf(valor), "Duracao invalida");
			setDuracao(Integer.valueOf(valor));
			break;
		case "nome":
			setNome(valor);
			break;
		case "objetivo":
			setObjetivo(valor);
			break;
		default:
			throw new ProjetoException("Atributo nulo ou invalido");
		}
	}

	public void addCusto(Custo custo) {
		custos.add(custo);
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

	/**
	 * retorna o professor coordenador no projeto
	 * 
	 * @return - professor coordenador
	 */
	final public Pessoa getCoordenador() {
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao p = (Participacao) it.next();
			if (p.getClass() == ParticipacaoProfessor.class) {
				ParticipacaoProfessor professor = (ParticipacaoProfessor) p;
				if (professor.getCoordenador()) {
					return professor.getPessoa();
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		Pessoa coordenador = getCoordenador();
		String nomeCoordenador = coordenador == null? "Não possui" : coordenador.getNome();
		return String.format("Nome: %s" + IO.NL
				+ "Data de inicio: %s" + IO.NL
				+ "Coordenador: %s" + IO.NL
				+ "Situacao: %s", nome, 
				DateUtil.formatDate(dataInicio, "dd/MM/yyyy"), nomeCoordenador, isEmAndamento()? "em andamento" : "finalizado");
	}
	
	public boolean isEmAndamento () {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataInicio);
		return (Calendar.getInstance().before(calendar));
	}
	
	public double calculaColaboracao(){
		double montante = 0;
		for(Custo custo : getCustos()){
			if (custo.getValor() > 10000){
				montante += custo.getValor();
			}
		}
		return montante;
	}

	public double calculaBemCapital() {
		double montante = 0;
		for(Custo custo : getCustos()){
			if (custo.getTipoCusto() == TipoCusto.CAPITAL){
				montante += custo.getValor();
			}
		}
		return montante;
	}

	public void atualizaDespesas(double montanteBolsas, double montanteCusteio, double montanteCapital){
		if (montanteBolsas < 0 || montanteCapital < 0 || montanteCusteio < 0){
			throw new ProjetoException("valor negativo");
		}
	}
	
	@Override
	public int compareTo(Projeto o) {
		return codigo - o.codigo;
	}
}
