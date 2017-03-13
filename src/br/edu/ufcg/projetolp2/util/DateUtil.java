package br.edu.ufcg.projetolp2.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * recebe uma string no formato dd/MM/yyyy e retorna a data correspondente
	 * @param data - string da data
	 * @return - Date com a data correspondente
	 * @throws ParseException - erro de conversao
	 */
	public static Date parseDate(String data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatter.setLenient(false);
		return formatter.parse(data);
	}
	
	/**
	 * recebe uma data e retorna uma string no formato dd/MM/yyyy correspondente
	 * @param data - Date com a data
	 * @return - String com a data correspondente
	 * @throws ParseException - erro de conversao
	 */
	public static String formatDate(Date data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(data);
	}	
}
