package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;

public class Pibiti extends Ped {
	
	public Pibiti(int codigo, String nome, String objetivo, String dataInicio, int duracao,
			int producaoTecnica, int producaoAcademica, int patentes) throws ParseException {
		super(codigo, nome, objetivo, dataInicio, duracao, producaoTecnica, producaoAcademica, patentes);
	}

	@Override
	public void adicionaParticipacao(Participacao participacao){
		if (participacao.getTipoParticipacao().getClass() == ParticipacaoProfessor.class){
			ParticipacaoProfessor professor = (ParticipacaoProfessor) participacao.getTipoParticipacao();
			if (!professor.getCoordenador() && super.getTotalParticipacoesProfessor() > 0){
				throw new ProjetoException("Projetos P&D nao pode ter mais de um professor");
			} else  if (professor.getCoordenador() && super.getTotalParticipacoesCoordenador() > 0){
				throw new ProjetoException("Projetos P&D nao pode ter mais de um Coordenador");
			}
		} else if (participacao.getTipoParticipacao().getClass() == ParticipacaoGraduando.class){
			if (super.getTotalParticipacoesGraduando() > 0){
				throw new ProjetoException("Projetos P&D nao podem ter mais de um graduando");
			}
		}
		super.adicionaParticipacao(participacao);
	}
}
