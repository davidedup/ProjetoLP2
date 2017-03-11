package br.edu.ufcg.projetolp2.model.projeto;

import java.util.ArrayList;
import java.util.Date;

public abstract class Projeto implements Participavel {

	private String nome;

	private String objetivo;

	private Date dataInicio;

	private int duracaoMeses;

	private int codigo;

	private ArrayList<Custo> custos;

	public Projeto(String nome, String objetivo, Date dataInicio, int duracao) {

	}

	public String getNome() {
		return null;
	}

	public String getObjetivo() {
		return null;
	}

	public Date getDataInicio() {
		return null;
	}

	public int getDuracao() {
		return 0;
	}

	public int getCodigo() {
		return 0;
	}

	public void setObjetivo(String objetivo) {

	}

	public void setNome(String nome) {

	}

	public void setDuracao(int duracao) {

	}

	public void addCusto(double valor, TipoCusto tipoCusto) {

	}

	public String toString() {
		return null;
	}

	public int hashCode() {
		return 0;
	}

	public boolean equals(Object obj) {
		return false;
	}

}
