package br.edu.ufcg.projetolp2.model.participacao.tipos;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public class ParticipacaoProfissional extends Participacao {
	private String cargo;
	
	public ParticipacaoProfissional(Projeto projeto, Pessoa pessoa, int horasSemanais, double valorHora, String cargo) {
		super(projeto, pessoa, horasSemanais, valorHora);
		
		setCargo(cargo);
	}

	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo){
		ValidateUtil.validaString(cargo, "Cargo nulo ou vazio");
		this.cargo = cargo;
	}
	
	@Override
	public double calculaPontos(){
		int tempo = getProjeto().getDuracao() / 12;
		double res = 0;
		
		if (getProjeto() instanceof Ped){
			switch(getCargo().toLowerCase()){
			case "desenvolvedor":
				res += tempo * 5;
				break;
				
			case "gerente":
				res += tempo * 9;
				break;
				
			case "pesquisador":
				res += tempo * 6;
				break;
			}
			
		}
		
		return res;
		
	}

	@Override
	public double calculaValorBolsa() {
		double base = getValorHora() * getQuantHorasSemanais();
		double acrescimo = 0;
		
		// para participacao de profissional, o adicional e por funcao
		switch (getCargo().toLowerCase()) {
		// pesquisador tem adicional R$100,00
		case "pesquisador":
			acrescimo += 100;
			break;

		// e gerente de R$ 20 por participante do projeto -- considerar no
		// máximo 5 participantes
		case "gerente":
			acrescimo += Math.min(5, getProjeto().getTotalParticipacoes()) * 20;
			break;
		}
		
		return Math.max(base+acrescimo, 350);
	}
}
