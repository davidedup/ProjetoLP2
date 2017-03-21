package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public class Pet extends Projeto {

	private int impacto;
	private int producaoTecnica;
	private int procucaoAcademica;
	private int patentes;
	private int rendimento;

	/**
	 * construtor de Pet
	 * @param codigo - codigo do projeto
	 * @param nome - nome do projeto
	 * @param objetivo - objetivo do projeto
	 * @param dataInicio - data de inicio do projeto
	 * @param duracao - duracao do projeto (em meses)
	 * @param impacto - impacto do projeto (varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil))
	 * @param producaoTecnica - numero de producoes tecnicas geradas no projeto
	 * @param producaoAcademica - numero de producoes academicas geradas no projeto
	 * @param patentes - numero de patentes geradas no projeo
	 * @param rendimento - expectativa de aprovacao
	 * @throws ParseException
	 */
	public Pet(int codigo, String nome, String objetivo, String dataInicio, int duracao, int impacto, int producaoTecnica, int producaoAcademica, int patentes, int rendimento) throws ParseException, ValidacaoException {
		super(codigo, nome, objetivo, dataInicio, duracao);
		
		setProducaoTecnica(producaoTecnica);
		setProducaoAcademica(producaoAcademica);
		setPatentes(patentes);
		setImpacto(impacto);
	}

	/**
	 * retorna o impacto do projeto
	 * @return -  impacto do projeto (varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil))
	 */
	public int getImpacto() {
		return this.impacto;
	}

	public int getProducaoTecnica() {
		return this.producaoTecnica;
	}

	public int getProducaoAcademica() {
		return this.procucaoAcademica;
	}

	public int getPatentes() {
		return this.patentes;
	}

	public int getRendimento() {
		return this.rendimento;
	}
	
	/**
	 * atualiza o valor do impacto do projeto
	 * @param impacto - impacto do projeto (varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil))
	 */
	public void setImpacto(int impacto) {
		ValidateUtil.validaImpacto(impacto);
		this.impacto = impacto;
	}

	public void setProducaoTecnica(int producao) {
		ValidateUtil.validaPositivo(producao, "Numero de producoes tecnicas invalido");
		this.producaoTecnica = producao;
	}

	public void setProducaoAcademica(int producao) {
		ValidateUtil.validaPositivo(producao, "Numero de producoes academicas invalido");
		this.procucaoAcademica = producao;
	}

	public void setPatentes(int patentes) {
		ValidateUtil.validaPositivo(patentes, "Numero de patentes invalido");
		this.patentes = patentes;
	}

	public void setRendimento(int rendimento) {
		ValidateUtil.validaRendimento(rendimento);
		this.rendimento = rendimento;
	}

	@Override
	public String getInfo(String atributo) {
		ValidateUtil.validaString(atributo, "Atributo nulo ou invalido");
		
		switch (atributo.toLowerCase()){
		case "impacto":
			return ""+getImpacto();
		
		case "patentes":
			return ""+getPatentes();
		
		case "producao academica":
			return ""+getProducaoAcademica();
			
		case "producao tecnica":
			return ""+getProducaoTecnica();
			
		default:
			return super.getInfo(atributo);
		}
	}

	@Override
	public void setInfo(String atributo, String valor) {
		ValidateUtil.validaString(atributo, "Atributo nulo ou invalido");
		ValidateUtil.validaString(atributo, atributo+" nulo ou vazio");
		
		switch (atributo.toLowerCase()){
		case "patentes":
			try{
				setPatentes(Integer.valueOf(valor));
			} catch (NumberFormatException e){
				throw new ValidacaoException("Numero de patentes invalido");
			}
		
		case "proucao academica":
			try{
				setProducaoAcademica(Integer.valueOf(valor));
			} catch (NumberFormatException e){
				throw new ValidacaoException("Numero de producoes academicas invalido");
			}			
			
		case "producao tecnica":
			try{
				setProducaoTecnica(Integer.valueOf(valor));
			} catch (NumberFormatException e){
				throw new ValidacaoException("Numero de producoes tecnicas invalido");
			}			
			
		case "rendimento":
			try{
				setRendimento(Integer.valueOf(valor));
			} catch (NumberFormatException e){
				throw new ValidacaoException("Rendimento invalido");
			}
			
		case "producao academica":
			throw new ProjetoException(tipoProjeto + " nao posssui " + atributo);
			
		default:
			super.setInfo(atributo, valor);
		}
	}
}
