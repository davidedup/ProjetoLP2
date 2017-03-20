package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;
import java.util.Date;

import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class Extensao extends Projeto {
	public String tipoProjeto = "Extensao";

	private int impacto;

	public Extensao(int codigo, String nome, String objetivo, String dataInicio, int duracao, int impacto) throws ParseException {
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
	public String getInfo(String atributo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInfo(String atributo, String valor) {
		// TODO Auto-generated method stub
		
	}
	
}
