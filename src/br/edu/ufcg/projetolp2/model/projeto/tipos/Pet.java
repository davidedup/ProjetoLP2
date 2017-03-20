package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;
import java.util.Date;

import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class Pet extends Projeto {

	private int impacto;
	private int producaoTecnica;
	private int procucaoAcademica;
	private int patentes;
	private int rendimento;

	public Pet(int codigo, String nome, String objetivo, String dataInicio, int duracao, int impacto, int producaoTecnica, int producaoAcademica, int patentes, int rendimento) throws ParseException {
		super(codigo, nome, objetivo, dataInicio, duracao);
	}

	/**
	 * retorna o impacto do projeto
	 * @return -  impacto do projeto (varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil))
	 */
	public int getImpacto() {
		return this.impacto;
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

	public int getRendimento() {
		return this.rendimento;
	}
	
	/**
	 * atualiza o valor do impacto do projeto
	 * @param impacto - impacto do projeto (varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil))
	 */
	public void setImpacto(int impacto) {
		this.impacto = impacto;
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

	public void setRendimento(int rendimento) {
		this.rendimento = rendimento;
	}

	@Override
	public String getInfo(String atributo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInfo(String atributo, String valor) {
		// TODO Auto-generated method stub
		
	}
}
