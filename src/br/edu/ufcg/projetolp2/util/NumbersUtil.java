package br.edu.ufcg.projetolp2.util;

public class NumbersUtil {
	public static boolean isNatural(int n){
		if (n >= 0){
			return true;
		}
		return false;
	}
	
	public static boolean isNaturalPositive(int n){
		if (n >= 1){
			return true;
		}
		return false;
	}
}
