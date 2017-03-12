package br.edu.ufcg.projetolp2.model.projeto;

import java.util.Date;

import br.edu.ufcg.projetolp2.exceptions.AssociacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;

public class Pet extends Projeto {

	private int impacto;
	private int producaoTecnica;
	private int procucaoAcademica;
	private int patentes;
	private int rendimento;
	private Pessoa tutor;

	public Pet(int codigo, String nome, String objetivo, Date dataInicio, int duracao, int impacto, int producaoTecnica, int producaoAcademica, int patentes, int rendimento) {
		super(codigo, nome, objetivo, dataInicio, duracao);
	}

	public int getImpacto() {
		return this.impacto;
	}

	public int getProducaoTecnica() {
		return this.producaoTecnica;
	}

	public int getProducaoAcademica() {
		return this.procucaoAcademica;
	}

	public int getPatentes() {
		return this.patentes;
	}

	public int getRendimento() {
		return this.rendimento;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}

	public void setProducaoTecnica(int producao) {
		this.producaoTecnica = producao;
	}

	public void setProducaoAcademica(int producao) {
		this.procucaoAcademica = producao;
	}

	public void setPatentes(int patentes) {
		this.patentes = patentes;
	}

	public void setRendimento(int rendimento) {
		this.rendimento = rendimento;
	}

	@Override
	public void adiciona(Participacao participacao) throws AssociacaoException {
		if (participacao.getTipoParticipacao().getTipoParticipacao().contains("PROFESSOR COORDENADOR")) {
			if (tutor == null)
				tutor = participacao.getPessoa();
			else
				throw new AssociacaoException("Erro na associacao de pessoa a projeto: Projetos PET nao podem ter mais de um coordenador");
		}
	}

	@Override
	public void remove(Participacao participacao) {
		if (participacao.getTipoParticipacao().getTipoParticipacao().contains("PROFESSOR COORDENADOR")) {
			tutor = null;
		}	
	}
}
