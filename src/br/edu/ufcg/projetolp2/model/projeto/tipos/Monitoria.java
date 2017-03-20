package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;
import java.util.Date;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public class Monitoria extends Projeto {
	public String tipoProjeto = "Monitoria";

	private String disciplina;
	private String periodo;
	private int rendimento;

	public Monitoria(int codigo, String nome, String objetivo, String dataInicio, int duracao, String disciplina, String periodo, int rendimento) throws ParseException {
		super(codigo, nome, objetivo, dataInicio, duracao);
		
		ValidateUtil.validaString(disciplina, "Disciplina nulo ou vazio");
		ValidateUtil.validaString(periodo, "Periodo nulo ou vazio");
		ValidateUtil.validaRendimento(rendimento);
		
		this.disciplina = disciplina;
		this.periodo = periodo;
		this.rendimento = rendimento;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public String getPeriodo() {
		return this.periodo;
	}
	
	public int getRendimento() {
		return this.rendimento;
	}

	public void setDisciplina(String disciplina) {
		//this.disciplina = disciplina;
		throw new ProjetoException("Nao e possivel alterar a disciplina da monitoria");
	}

	public void setPeriodo(String periodo) {
		ValidateUtil.validaString(periodo, "Periodo nulo ou vazio");
		this.periodo = periodo;
	}
	
	public void setRendimento(int rendimento){
		ValidateUtil.validaRendimento(rendimento);
		this.rendimento = rendimento;
	}

	@Override
	public String getInfo(String atributo) {
		ValidateUtil.validaString(atributo, "Atributo nulo ou vazio");
		
		switch (atributo.toLowerCase()){
		case "disciplina":
			return getDisciplina();
		
		case "periodo":
			return getPeriodo();
			
		case "rendimento":
			return ""+getRendimento();
			
		default:
			super.getInfo(atributo);
		}
		
		throw new ProjetoException(tipoProjeto + " nao posssui " + atributo);
	}

	@Override
	public void setInfo(String atributo, String valor) {
		// TODO Auto-generated method stub		
	}
}
