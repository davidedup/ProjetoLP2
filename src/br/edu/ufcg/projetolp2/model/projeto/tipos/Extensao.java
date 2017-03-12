package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.util.Date;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class Extensao extends Projeto {

	private int impacto;

	public Extensao(int codigo, String nome, String objetivo, Date dataInicio, int duracao, int impacto) {
		super(codigo, nome, objetivo, dataInicio, duracao);
		this.impacto = impacto;
	}

	public int getImpacto() {
		return this.impacto;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}

	@Override
	public void adiciona(Participacao participacao) {
		return;
	}

	@Override
	public void remove(Participacao participacao) {
		return;
	}

}
