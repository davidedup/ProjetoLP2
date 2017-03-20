package br.edu.ufcg.projetolp2.model;

public interface Atributavel {
	
	/**
	 * retorna em forma de String o atributo solicitado
	 * @param atributo - atributo a ser retornado
	 * @return - atributo solicitado em forma de string
	 */
	String getInfo(String atributo);
	
	/**
	 * atualiza o atributo solicitado para o novo valor fornecido 
	 * @param atributo - atributo a ser atualizado
	 * @param valor - valor a ser atualizado no atributo
	 */
	void setInfo(String atributo, String valor);
}
