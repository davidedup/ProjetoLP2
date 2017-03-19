package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.util.Date;

public class Pibiti extends Ped {
	
	public Pibiti(int codigo, String nome, String objetivo, Date dataInicio, int duracao,
			int producaoTecnica, int producaoAcademica, int patentes) {
		super(codigo, nome, objetivo, dataInicio, duracao, producaoTecnica, producaoAcademica, patentes);
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
