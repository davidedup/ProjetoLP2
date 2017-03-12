package br.edu.ufcg.projetolp2.model.projeto;

import java.util.Date;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;

public class Pet extends Projeto {

	private int impacto;
	private int producaoTecnica;
	private int procucaoAcademica;
	private int patentes;
	private int rendimento;
	private Pessoa tutor;
	private Projeto projeto;

	public Pet(String nome, String objetivo, Date dataInicio, int duracao, int impacto, int producaoTecnica, int producaoAcademica, int patentes, int rendimento) {
		super(nome, objetivo, dataInicio, duracao);
	}

	public int getImpacto() {
		return 0;
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

	public int getRendimento() {
		return 0;
	}

	public void setImpacto(int impacto) {

	}

	public void setProducaoTecnica(int producao) {

	}

	public void setProducaoAcademica(int producao) {

	}

	public void setPatentes(int patentes) {

	}

	public void setRendimento(int rendimento) {

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
