package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;
import java.util.Date;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public class Extensao extends Projeto {
	public String tipoProjeto = "Extensao";

	private int impacto;

	/**
	 * construtor de Extensao
	 * @param codigo - codigo do projeto
	 * @param nome - nome do projeto
	 * @param objetivo - objetivo do projeto
	 * @param dataInicio - data de inicio do projeto
	 * @param duracao - duracao do projeto (em meses)
	 * @param impacto - impacto do projeto: 1- comunidade academica, 2- cidade, 3- regiao (dentro do estado), 4- estado, 5- regiao (dentro da federacao/Brasil), 6- federacao (Brasil)
	 * @throws ParseException
	 */
	public Extensao(int codigo, String nome, String objetivo, String dataInicio, int duracao, int impacto) throws ParseException {
		super(codigo, nome, objetivo, dataInicio, duracao);
		
		ValidateUtil.validaImpacto(impacto);
		this.impacto = impacto;
	}

	/**
	 * retorna o impacto (entre 1 e 6 inclusivo)
	 * @return - impacto do projeto: 1- comunidade academica, 2- cidade, 3- regiao (dentro do estado), 4- estado, 5- regiao (dentro da federacao/Brasil), 6- federacao (Brasil)
	 */
	public int getImpacto() {
		return this.impacto;
	}

	/**
	 * atualiza o impacto (de 1 a 6 inclusivo)
	 * @param impacto - impacto do projeto: 1- comunidade academica, 2- cidade, 3- regiao (dentro do estado), 4- estado, 5- regiao (dentro da federacao/Brasil), 6- federacao (Brasil)
	 */
	public void setImpacto(int impacto) {
		ValidateUtil.validaImpacto(impacto);
		this.impacto = impacto;
	}

	@Override
	public String getInfo(String atributo) {
		ValidateUtil.validaString(atributo, "Atributo nulo ou invalido");
		
		switch (atributo.toLowerCase()){
		case "impacto":
			return ""+getImpacto();
			
		default:
			super.getInfo(atributo);
		}
		
		throw new ProjetoException("Atributo nulo ou invalido");
	}

	@Override
	public void setInfo(String atributo, String valor) {
		ValidateUtil.validaString(atributo, "Atributo nulo ou invalido");
		ValidateUtil.validaString(atributo, atributo+" nulo ou vazio");
		
		switch (atributo.toLowerCase()){
		case "impacto":
			try{
				Integer.valueOf(valor);
			} catch (Exception e){
				throw new ValidacaoException("Impacto invalido");
			}
			setImpacto(Integer.valueOf(valor));
		
		default:
			super.getInfo(atributo);
		}
		
		throw new ProjetoException("Atributo nulo ou invalido");
	}
	
}
