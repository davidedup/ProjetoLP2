package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.util.Date;

import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public abstract class Ped extends Projeto {

	private CategoriaPeD categoria;
	private int producaoTecnica;
	private int procucaoAcademica;
	private int patentes;

	public Ped(int codigo, String nome, String objetivo, Date dataInicio, int duracao, CategoriaPeD categoria, int producaoTecnica, int producaoAcademica, int patentes) {
		super(codigo, nome, objetivo, dataInicio, duracao);
		this.categoria = categoria;
		this.producaoTecnica = producaoTecnica;
		this.procucaoAcademica = producaoAcademica;
		this.patentes = patentes;
	}

	public CategoriaPeD getCategoria() {
		return this.categoria;
	}

	public int getProducaoTecnica() {
		return this.producaoTecnica;
	}

	public int getProducaoAcademica() {
		return this.procucaoAcademica;
	}

	public int getPatentes() {
		return this.patentes;
	}

	public void setCategoria(CategoriaPeD categoria) {
		this.categoria = categoria;
	}

	public void setProducaoTecnica(int producao) {
		this.producaoTecnica = producao;
	}

	public void setProducaoAcademica(int producao) {
		this.procucaoAcademica = producao;
	}

	public void setPatentes(int patentes) {
		this.patentes = patentes;
	}

}
