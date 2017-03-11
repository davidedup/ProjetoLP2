package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.util.Date;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;

public class Pibic extends Ped {

	private Pessoa aluno;
	private Pessoa orientador;
	
	public Pibic(String nome, String objetivo, Date dataInicio, int duracao, CategoriaPeD categoria,
			int producaoTecnica, int producaoAcademica, int patentes) {
		super(nome, objetivo, dataInicio, duracao, categoria, producaoTecnica, producaoAcademica, patentes);
		// TODO Auto-generated constructor stub
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
