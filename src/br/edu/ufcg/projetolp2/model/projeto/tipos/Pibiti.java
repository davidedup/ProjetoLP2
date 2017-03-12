package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.util.Date;

import br.edu.ufcg.projetolp2.exceptions.AssociacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;

public class Pibiti extends Ped {

	private Pessoa aluno;
	private Pessoa orientador;
	
	public Pibiti(int codigo, String nome, String objetivo, Date dataInicio, int duracao, CategoriaPeD categoria,
			int producaoTecnica, int producaoAcademica, int patentes) {
		super(codigo, nome, objetivo, dataInicio, duracao, categoria, producaoTecnica, producaoAcademica, patentes);
	}

	@Override
	public void adiciona(Participacao participacao) throws AssociacaoException {
		if (participacao.getTipoParticipacao().getTipoParticipacao().equals("PROFESSOR")) {
			if (orientador == null)
				orientador = participacao.getPessoa();
			else
				throw new AssociacaoException("Erro na associacao de pessoa a projeto: Projetos P&D nao podem ter mais de um professor");
		} if (participacao.getTipoParticipacao().getTipoParticipacao().equals("GRADUANDO")) {
			if (aluno == null)
				aluno = participacao.getPessoa();
			else
				throw new AssociacaoException("Erro na associacao de pessoa a projeto: Projetos P&D nao podem ter mais de um graduando");
		}
	}

	@Override
	public void remove(Participacao participacao) {
		if (participacao.getTipoParticipacao().getTipoParticipacao().equals("PROFESSOR")) {
			orientador = null;
		} if (participacao.getTipoParticipacao().getTipoParticipacao().equals("GRADUANDO")) {
			aluno = null;
		}
	}

}
