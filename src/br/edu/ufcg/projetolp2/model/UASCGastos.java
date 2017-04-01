package br.edu.ufcg.projetolp2.model;

import br.edu.ufcg.projetolp2.exceptions.CpcException;

/**
 * Representa a entidade que calcula os gastos e créditos da UASC.
 *
 */
public class UASCGastos {
	private double debito;
	private double credito;
	
	public UASCGastos(double debito, double credito) {
		this.debito = debito;
		this.credito = credito;
	}
	
	public double getTotal(){
		return credito - debito;
	}

	public double getDebito() {
		return debito;
	}
	
	public void addDebito(double debito) {
		if (debito < 0){
			throw new CpcException("Erro na atualizacao da receita da unidade: valor negativo");
		} else if(getTotal() - debito < 0){
			throw new CpcException("Erro na atualizacao da receita da unidade: a unidade nao possui fundos suficientes");
		} else{
			this.debito += debito;
		}
	}
	
	public double getCredito() {
		return credito;
	}
	
	public void setCredito(double credito) {
		this.credito = credito;
	}
}
