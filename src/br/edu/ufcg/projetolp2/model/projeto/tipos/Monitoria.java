package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.util.Date;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class Monitoria extends Projeto {

	private String disciplina;
	private String periodo;
	private int expectativaDeAprovacao;
	private Pessoa orientador;
	private Projeto projeto;

	public Monitoria(String nome, String objetivo, Date dataInicio, int duracao, String disciplina, String periodo, int expectativa) {
		super(nome, objetivo, dataInicio, duracao);
	}

	public String getDisciplina() {
		return null;
	}

	public String getPeriodo() {
		return null;
	}

	public int getExpectativaDeAprovacao() {
		return 0;
	}

	public void setDisciplina(String disciplina) {

	}

	public void setPeriodo(String periodo) {

	}

	public void setExpectativaDeAprovacao(int expecttiva) {

	}

	@Override
	public void adiciona(Participacao participacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Participacao participacao) {
		// TODO Auto-generated method stub
		
	}

}
