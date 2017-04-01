package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;
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
		this.disciplina = disciplina;
		
		setPeriodo(periodo);
		setRendimento(rendimento);
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
		ValidateUtil.validaString(atributo, "Atributo nulo ou invalido");
		
		switch (atributo.toLowerCase()){
		case "disciplina":
			return getDisciplina();
		
		case "periodo":
			return getPeriodo();
			
		case "rendimento":
			return ""+getRendimento();
		case "producao academica":
			throw new ValidacaoException("Monitoria nao possui Producao academica");
		default:
			return super.getInfo(atributo);
		}
	}

	@Override
	public void setInfo(String atributo, String valor) {
		ValidateUtil.validaString(atributo, "Atributo nulo ou invalido");
		ValidateUtil.validaString(atributo, atributo+" nulo ou vazio");
		
		switch (atributo.toLowerCase()){
		case "disciplina":
			setDisciplina(valor);
		
		case "periodo":
			setPeriodo(valor);
			
		case "rendimento":
			try{
				setRendimento(Integer.valueOf(valor));
			} catch (NumberFormatException e){
				throw new ValidacaoException("Rendimento invalido");
			}
			
			
		default:
			super.setInfo(atributo, valor);
		}
	}
	
	@Override
	public void adicionaParticipacao(Participacao participacao){
		if (participacao.getClass() == ParticipacaoProfessor.class){
			ParticipacaoProfessor professor = (ParticipacaoProfessor) participacao;
			if (!professor.getCoordenador() && participacao.getValorHora() != 0){
				throw new ProjetoException("Valor da hora de um professor da monitoria deve ser zero");
			} else if (!professor.getCoordenador() && super.getTotalParticipacoesProfessor() > 0){
				throw new ProjetoException("Monitoria nao pode ter mais de um professor");
			} else  if (professor.getCoordenador() && super.getTotalParticipacoesCoordenador() > 0){
				throw new ProjetoException("Monitoria nao pode ter mais de um Coordenador");
			}
		}
		super.adicionaParticipacao(participacao);
	}
	
	@Override
	public double calculaValorBolsa(Participacao p){
		if (p.getClass() == ParticipacaoProfessor.class){
			return 0;
		} else {
			return super.calculaValorBolsa(p);
		}
	}
}
