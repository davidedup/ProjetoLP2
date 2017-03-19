package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.util.Date;

import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class Monitoria extends Projeto {

	private String disciplina;
	private String periodo;

	public Monitoria(int codigo, String nome, String objetivo, Date dataInicio, int duracao, String disciplina, String periodo) {
		super(codigo, nome, objetivo, dataInicio, duracao);
		this.disciplina = disciplina;
		this.periodo = periodo;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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
