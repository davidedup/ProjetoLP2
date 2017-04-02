package br.edu.ufcg.projetolp2.model.projeto.tipos;

import java.text.ParseException;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;
import br.edu.ufcg.projetolp2.model.projeto.Custo;
import br.edu.ufcg.projetolp2.model.projeto.TipoCusto;

public class Cooperacao extends Ped {
	
	public Cooperacao(int codigo, String nome, String objetivo, String dataInicio, int duracao, int producaoTecnica, int producaoAcademica, int patentes) throws ParseException {
		super(codigo, nome, objetivo, dataInicio, duracao, producaoTecnica, producaoAcademica, patentes);
	}

	@Override
	public void adicionaParticipacao(Participacao participacao){
		if (participacao.getClass() == ParticipacaoProfessor.class){
			ParticipacaoProfessor professor = (ParticipacaoProfessor) participacao;
			if (professor.getCoordenador() && super.getTotalParticipacoesCoordenador() > 0){
				throw new ProjetoException("Projetos P&D nao podem ter mais de um coordenador");
			}
		}
		super.adicionaParticipacao(participacao);
	}

	
	@Override
	public void atualizaDespesas(double montanteBolsas, double montanteCusteio, double montanteCapital) {
		super.atualizaDespesas(montanteBolsas, montanteCusteio, montanteCapital);
		if (montanteCapital == 0 || montanteCusteio == 0 || montanteBolsas == 0) {
			throw new ProjetoException("projeto do tipo Coop devem possuir todas as despesas");
		}
		
		addCusto(new Custo(montanteBolsas, TipoCusto.BOLSA));
		addCusto(new Custo(montanteCapital, TipoCusto.CAPITAL));
		addCusto(new Custo(montanteCusteio, TipoCusto.CUSTEIO));
	}
}
