package br.edu.ufcg.projetolp2.model.projeto;

public class Custo {

	private double valor;
	private TipoCusto tipoCusto;

	public Custo(double valor, TipoCusto tipoCusto) {
		this.valor = valor;
		this.tipoCusto = tipoCusto;
	}

	public double getValor() {
		return this.valor;
	}

	public TipoCusto getTipoCusto() {
		return this.tipoCusto;
	}
	
}
