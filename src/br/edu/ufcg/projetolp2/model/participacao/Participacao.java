package br.edu.ufcg.projetolp2.model.participacao;

import java.util.Date;

import br.edu.ufcg.projetolp2.model.participacao.tipos.TipoParticipacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class Participacao {

	private Date dataDeInicio;
	private int duracao;
	private int quantHorasSemanais;
	private double valorHora;
	private Pessoa pessoa;
	private Projeto projeto;
	private TipoParticipacao tipoParticipacao;

	public Participacao(Projeto projeto, Pessoa pessoa, Date dataDeInicio, int duracao, int horasSemanais, double valorHora, TipoParticipacao tipoParticipacao) {

	}

	public Date getDataDeInicio() {
		return null;
	}

	public int getDuracao() {
		return 0;
	}

	public int getQuantHorasSemanais() {
		return 0;
	}

	public double getValorHora() {
		return 0;
	}

	public Pessoa getPessoa() {
		return null;
	}

	public Projeto getProjeto() {
		return null;
	}

	public void setDuracao(int duracao) {

	}

	public void setQuantHorasSemanais(int quant) {

	}

	public void setValorHora(double valor) {

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
	
	public String toString() {
		//TODO
		return null;
	}

}
