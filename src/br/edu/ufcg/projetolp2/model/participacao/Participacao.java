package br.edu.ufcg.projetolp2.model.participacao;

import br.edu.ufcg.projetolp2.model.participacao.tipos.TipoParticipacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class Participacao {

	private int quantHorasSemanais;
	private double valorHora;
	private Pessoa pessoa;
	private Projeto projeto;
	private TipoParticipacao tipoParticipacao;

	public Participacao(Projeto projeto, Pessoa pessoa, int horasSemanais, double valorHora, TipoParticipacao tipoParticipacao) {
		this.pessoa = pessoa;
		this.projeto = projeto;
		this.quantHorasSemanais = horasSemanais;
		this.tipoParticipacao = tipoParticipacao;
		this.valorHora = valorHora;
	}

	public int getQuantHorasSemanais() {
		return this.quantHorasSemanais;
	}

	public double getValorHora() {
		return this.valorHora;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}
	
	public TipoParticipacao getTipoParticipacao() {
		return this.tipoParticipacao;
	}

	public void setQuantHorasSemanais(int quant) {
		this.quantHorasSemanais = quant;
	}

	public void setValorHora(double valor) {
		this.valorHora = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participacao other = (Participacao) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (projeto == null) {
			if (other.projeto != null)
				return false;
		} else if (!projeto.equals(other.projeto))
			return false;
		return true;
	}

}
