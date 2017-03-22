package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;

public class Cooperacao extends Ped {
	//Pessoa coordenador;
	
	public Cooperacao(int codigo, String nome, String objetivo, String dataInicio, int duracao, int producaoTecnica, int producaoAcademica, int patentes) throws ParseException {
		super(codigo, nome, objetivo, dataInicio, duracao, producaoTecnica, producaoAcademica, patentes);
		//coordenador = null;
	}

	@Override
	public void adicionaParticipacao(Participacao participacao){
		if (participacao.getClass() == ParticipacaoProfessor.class){
			ParticipacaoProfessor professor = (ParticipacaoProfessor) participacao;
			if (professor.getCoordenador() && super.getTotalParticipacoesCoordenador() > 0){
				throw new ProjetoException("Projetos P&D nao podem ter mais de um coordenador");
			}
		}
		super.adicionaParticipacao(participacao);
	}
}
