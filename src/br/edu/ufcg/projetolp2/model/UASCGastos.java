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
	
	/**
	 *	Retorna o valor total gerado ao calcular os créditos subtraidos com 
	 * as despesas. 
	 * @return - total
	 */
	public double getTotal(){
		return credito - debito;
	}

	public double getDebito() {
		return debito;
	}
	
	/** 
	 * Recebe um valor e adiciona aos debitos se ele for válido.
	 * Só são validos valores acima de 0 e que ao subtraídos com
	 * o montante atual, seja positivo.
	 * @param debito - valor a ser debitado.
	 */
	public void addDebito(double debito) {
		if (debito < 0){
			throw new CpcException("Erro na atualizacao da receita da unidade: valor negativo");
		} else if(getTotal() - debito < 0){
			throw new CpcException("Erro na atualizacao da receita da unidade: a unidade nao possui fundos suficientes");
		} else{
			this.debito += debito;
		}
	}

	/**
	 * Recebe uma nova quantia e a salva.
	 * @param montante - credito a ser adicionado
	 */
	public void addCredito(double montante) {
		credito += montante;
	}
}
