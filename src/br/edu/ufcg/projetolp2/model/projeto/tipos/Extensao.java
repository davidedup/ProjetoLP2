package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.util.Date;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class Extensao extends Projeto {

	private int impacto;

	private Projeto projeto;

	public Extensao(String nome, String objetivo, Date dataInicio, int duracao, int impacto) {
		super(nome, objetivo, dataInicio, duracao);
	}

	public int getImpacto() {
		return 0;
	}

	public void setImpacto(int impacto) {

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
