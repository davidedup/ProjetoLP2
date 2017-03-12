package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.util.Date;

import br.edu.ufcg.projetolp2.exceptions.AssociacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class Monitoria extends Projeto {

	private String disciplina;
	private String periodo;
	private Pessoa orientador;

	public Monitoria(int codigo, String nome, String objetivo, Date dataInicio, int duracao, String disciplina, String periodo) {
		super(codigo, nome, objetivo, dataInicio, duracao);
		this.disciplina = disciplina;
		this.periodo = periodo;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@Override
	public void adiciona(Participacao participacao) throws AssociacaoException {
		if (participacao.getTipoParticipacao().getTipoParticipacao().equals("PROFESSOR")) {
			if (orientador == null)
				orientador = participacao.getPessoa();
			else
				throw new AssociacaoException("Erro na associacao de pessoa a projeto: Monitoria nao pode ter mais de um professor");
		}
	}

	@Override
	public void remove(Participacao participacao) {
		if (participacao.getTipoParticipacao().getTipoParticipacao().equals("PROFESSOR")) {
			orientador = null;
		}
	}

}
