package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.util.Date;

import br.edu.ufcg.projetolp2.exceptions.AssociacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;

public class Cooperacao extends Ped {

	private Pessoa coordenador;
	
	public Cooperacao(int codigo, String nome, String objetivo, Date dataInicio, int duracao,
			int producaoTecnica, int producaoAcademica, int patentes) {
		super(codigo, nome, objetivo, dataInicio, duracao, producaoTecnica, producaoAcademica, patentes);
	}

	@Override
	public void adiciona(Participacao participacao) throws AssociacaoException {
		if (participacao.getTipoParticipacao().getTipoParticipacao().equals("PROFESSOR COORDENADOR")){
			if (coordenador == null)
				coordenador = participacao.getPessoa();
			else
				throw new AssociacaoException("Erro na associacao de pessoa a projeto: Projetos P&D nao podem ter mais de um coordenador");
		}		
	}

	@Override
	public void remove(Participacao participacao) {
		if (participacao.getTipoParticipacao().getTipoParticipacao().equals("PROFESSOR COORDENADOR")){
			coordenador = null;
		}
	}

}
