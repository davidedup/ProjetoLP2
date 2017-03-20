package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;
import java.util.Date;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public abstract class Ped extends Projeto {
	public String tipoProjeto = "P&D";

	private int producaoTecnica;
	private int procucaoAcademica;
	private int patentes;

	/**
	 * construtor de Ped (P&D)
	 * @param codigo - codigo do projeto
	 * @param nome - nome do projeto
	 * @param objetivo - objetivo do projeto
	 * @param dataInicio - data de inicio do projeto
	 * @param duracao - duracao do projeto (em meses)
	 * @param producaoTecnica - total de producoes tecnicas do projeto de P&D
	 * @param producaoAcademica - total de producoes academicas do projeto de P&D
	 * @param patentes - total de producoes patentes de P&D
	 * @throws ParseException - Erro ao converter a data de inicio
	 */
	public Ped(int codigo, String nome, String objetivo, String dataInicio, int duracao, int producaoTecnica, int producaoAcademica, int patentes) throws ParseException {
		super(codigo, nome, objetivo, dataInicio, duracao);
		
		ValidateUtil.validaPositivo(producaoTecnica, "Numero de producoes tecnicas invalido");
		ValidateUtil.validaPositivo(producaoAcademica, "Numero de producoes academicas invalido");
		ValidateUtil.validaPositivo(patentes, "Numero de patentes invalido");
		
		this.producaoTecnica = producaoTecnica;
		this.procucaoAcademica = producaoAcademica;
		this.patentes = patentes;
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
	
	@Override
	public String getInfo(String atributo) {
		ValidateUtil.validaString(atributo, "Atributo nulo ou invalido");
		
		switch (atributo.toLowerCase()){
		case "patentes":
			return ""+getPatentes();
		
		case "producao academica":
			return ""+getProducaoAcademica();
			
		case "producao tecnica":
			return ""+getProducaoTecnica();
			
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
		case "patentes":
			try{
				Integer.valueOf(valor);
			} catch (Exception e){
				throw new ValidacaoException("Numero de patentes invalido");
			}
			setPatentes(Integer.valueOf(valor));
		
		case "proucao academica":
			try{
				Integer.valueOf(valor);
			} catch (Exception e){
				throw new ValidacaoException("Numero de producoes academicas invalido");
			}
			setProducaoAcademica(Integer.valueOf(valor));
			
		case "producao tecnica":
			try{
				Integer.valueOf(valor);
			} catch (Exception e){
				throw new ValidacaoException("Numero de producoes tecnicas invalido");
			}
			setProducaoTecnica(Integer.valueOf(valor));		
			
		default:
			super.getInfo(atributo);
		}
		
		throw new ProjetoException("Atributo nulo ou invalido");
	}

}
