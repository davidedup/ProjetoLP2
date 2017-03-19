package br.edu.ufcg.projetolp2.model.projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.model.Atributavel;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.TipoParticipacao;

public abstract class Projeto implements Atributavel{
	
	private String nome;
	private String objetivo;
	private Date dataInicio;
	private int duracaoMeses;
	private int codigo;
	private List<Custo> custos;
	private List<Participacao> participacoes;

	public Projeto(int codigo, String nome, String objetivo, Date dataInicio, int duracao) {
		this.nome = nome;
		this.objetivo = objetivo;
		this.dataInicio = dataInicio;
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
		this.objetivo = objetivo;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDuracao(int duracao) {
		this.duracaoMeses = duracao;
	}

	public void addCusto(double valor, TipoCusto tipoCusto) {
		Custo custo = new Custo(valor, tipoCusto);
		this.custos.add(custo);
	}
	
	public String getParticipacoes() {
		//TODO
		return null;
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
	}

	public String toString() {
		//TODO
		return null;
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
		if (this == obj)
			return true;
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
