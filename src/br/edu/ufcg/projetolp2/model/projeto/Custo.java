package br.edu.ufcg.projetolp2.model.projeto;

import java.io.Serializable;

public class Custo implements Serializable {

	private double valor;
	private TipoCusto tipoCusto;

	/**
	 * Construtor de Custo
	 * @param valor - valor do custo
	 * @param tipoCusto - tipo do custo
	 */
	public Custo(double valor, TipoCusto tipoCusto) {
		this.valor = valor;
		this.tipoCusto = tipoCusto;
	}

	/**
	 * retorna o valor do custo
	 * @return - valor do custo
	 */
	public double getValor() {
		return this.valor;
	}
	
	/**
	 * retorna o tipo do custo
	 * @return - tipo do custo
	 */
	public TipoCusto getTipoCusto() {
		return this.tipoCusto;
	}
	
}
