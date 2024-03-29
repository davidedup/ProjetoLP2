package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.projeto.Custo;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.TipoCusto;
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
		
		setImpacto(impacto);
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
			return super.getInfo(atributo);
		}
	}

	@Override
	public void setInfo(String atributo, String valor) {
		ValidateUtil.validaString(atributo, "Atributo nulo ou invalido");
		ValidateUtil.validaString(atributo, atributo+" nulo ou vazio");
		
		switch (atributo.toLowerCase()){
		case "impacto":
			try{
				setImpacto(Integer.valueOf(valor));
			} catch (NumberFormatException e){
				throw new ValidacaoException("Impacto invalido");
			}
			
		
		default:
			super.setInfo(atributo, valor);
		}
		
		throw new ProjetoException("Atributo nulo ou invalido");
	}

	@Override
	public double calculaColaboracao() {
		double total = super.calculaColaboracao();
		double desconto = 0.1 - (0.005 * impacto);
		return total * desconto;
	}

	@Override
	public void atualizaDespesas(double montanteBolsas, double montanteCusteio, double montanteCapital) {
		super.atualizaDespesas(montanteBolsas, montanteCusteio, montanteCapital);
		if (montanteCapital != 0){
			throw new ProjetoException("projeto do tipo Extensao nao permite despesas de capital");
		}
		addCusto(new Custo(montanteBolsas, TipoCusto.BOLSA));
		addCusto(new Custo(montanteCusteio, TipoCusto.CUSTEIO));
	}
	
}
