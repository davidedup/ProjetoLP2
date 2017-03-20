package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;
import java.util.Date;

import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public abstract class Ped extends Projeto {
	public String tipoProjeto = "P&D";

	private int producaoTecnica;
	private int procucaoAcademica;
	private int patentes;

	public Ped(int codigo, String nome, String objetivo, String dataInicio, int duracao, int producaoTecnica, int producaoAcademica, int patentes) throws ParseException {
		super(codigo, nome, objetivo, dataInicio, duracao);
		this.producaoTecnica = producaoTecnica;
		this.procucaoAcademica = producaoAcademica;
		this.patentes = patentes;
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
