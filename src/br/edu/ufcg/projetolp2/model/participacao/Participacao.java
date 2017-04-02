package br.edu.ufcg.projetolp2.model.participacao;

import java.io.Serializable;

import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public abstract class Participacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quantHorasSemanais;
	private double valorHora;
	private Pessoa pessoa;
	private Projeto projeto;

	public Participacao(Projeto projeto, Pessoa pessoa, int horasSemanais, double valorHora) {
		this.pessoa = pessoa;
		this.projeto = projeto;
		
		setQuantHorasSemanais(horasSemanais);
		setValorHora(valorHora);
	}

	/**
	 * Método que retorna a quantidade de horas semanais trabalhadas pela pessoa no projeto
	 * @return int representando a quantidade de horas semanains
	 */
	public int getQuantHorasSemanais() {
		return this.quantHorasSemanais;
	}

	/**
	 * Método que retorna o valor da hora de trabalho da pessoa no projeto
	 * @return double representando o valor em reais da hora de trabalho
	 */
	public double getValorHora() {
		return this.valorHora;
	}

	/**
	 * Método que retorna a pessoa que está associada ao projeto
	 * @return objeto {@link Pessoa} cuja está associada ao projeto
	 */
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	/**
	 * Método que retorna o projeto ao qual a pessoa está associada
	 * @return objeto {@link Projeto}
	 */
	public Projeto getProjeto() {
		return this.projeto;
	}
	

	public void setQuantHorasSemanais(int quant) {
		ValidateUtil.validaPositivo(quant, "Quantidade de horas invalida");
		this.quantHorasSemanais = quant;
	}

	public void setValorHora(double valor) {
		if (projeto instanceof Ped){
			ValidateUtil.validaPositivo(valor, "Valor da hora invalido");
		} else {
			ValidateUtil.validaNatural(valor, "Valor da hora invalido");
		}
		
		this.valorHora = valor;
	}
	
	public abstract double calculaPontos();

	public abstract double calculaValorBolsa();
	
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
