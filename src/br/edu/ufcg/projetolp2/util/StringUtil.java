package br.edu.ufcg.projetolp2.util;

public class StringUtil {
	
	/**
	 * retorna true se a string for nula
	 * @param s - string a ser verificada
	 * @return - string eh nula?
	 */
	public static boolean isStringNula(String s){
		if (s == null){
			return true;
		}
		return false;
	}
	
	/**
	 * retorna true se a string for vazia
	 * @param s - string a ser verificada
	 * @return - string eh vazia?
	 */
	public static boolean isStringVazia(String s){
		if (s.trim().equals("")){
			return true;
		}
		return false;
	}
}