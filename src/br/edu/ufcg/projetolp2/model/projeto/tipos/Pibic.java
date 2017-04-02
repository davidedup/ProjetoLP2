package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoPosGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;
import br.edu.ufcg.projetolp2.model.projeto.Custo;
import br.edu.ufcg.projetolp2.model.projeto.TipoCusto;

public class Pibic extends Ped {
	
	public Pibic(int codigo, String nome, String objetivo, String dataInicio, int duracao, int producaoTecnica, int producaoAcademica, int patentes) throws ParseException {
		super(codigo, nome, objetivo, dataInicio, duracao, producaoTecnica, producaoAcademica, patentes);
	}
	
	@Override
	public void adicionaParticipacao(Participacao participacao){
		if (participacao.getClass() == ParticipacaoProfessor.class){
			ParticipacaoProfessor professor = (ParticipacaoProfessor) participacao;
			
			if (!professor.getCoordenador() && super.getTotalParticipacoesProfessor() > 0){
				throw new ProjetoException("Projetos P&D nao podem ter mais de um professor");
			} else  if (professor.getCoordenador() && super.getTotalParticipacoesCoordenador() > 0){
				throw new ProjetoException("Projetos P&D nao podem ter mais de um coordenador");
			}
			
		} else if (participacao.getClass() == ParticipacaoGraduando.class){
			if (super.getTotalParticipacoesGraduando() > 0){
				throw new ProjetoException("Projetos P&D nao podem ter mais de um graduando");
			}
		}  else if(participacao.getClass() == ParticipacaoPosGraduando.class){
			throw new ProjetoException("Tipo de projeto invalido para pos graduando");
		}
		super.adicionaParticipacao(participacao);
	}
	
	@Override
	public void atualizaDespesas(double montanteBolsas, double montanteCusteio, double montanteCapital) {
		super.atualizaDespesas(montanteBolsas, montanteCusteio, montanteCapital);
		
		if (montanteBolsas == 0){
			throw new ProjetoException("projeto do tipo P&D - PIBIC ou PIBIT deve permitir despesas de bolsas");
		}
		if (montanteCapital != 0 || montanteCusteio != 0) {
			throw new ProjetoException("projeto do tipo P&D - PIBIC ou PIBIT nao permite despesas de custeio ou capital");
		}
		
		addCusto(new Custo(montanteBolsas, TipoCusto.BOLSA));
	}
	
	@Override
	public double calculaColaboracao() {
		return 0;
	}


}
