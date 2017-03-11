package br.edu.ufcg.projetolp2.model.projeto.tipos;

import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public abstract class Ped extends Projeto {

	private CategoriaPeD categoria;

	private int producaoTecnica;

	private int procucaoAcademica;

	private int patentes;

	private Projeto projeto;

	public PeD(String nome, String objetivo, Date dataInicio, int duracao, CategoriaPeD categoria, int producaoTecnica, int producaoAcademica, int patentes) {

	}

	public CategoriaPeD getCategoria() {
		return null;
	}

	public int getProducaoTecnica() {
		return 0;
	}

	public int getProducaoAcademica() {
		return 0;
	}

	public int getPatentes() {
		return 0;
	}

	public void setCategoria(CategoriaPeD categoria) {

	}

	public void setProducaoTecnica(int producao) {

	}

	public void setProducaoAcademica(int producao) {

	}

	public void setPatentes(int patentes) {

	}

}
