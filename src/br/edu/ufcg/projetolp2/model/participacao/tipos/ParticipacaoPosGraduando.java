package br.edu.ufcg.projetolp2.model.participacao.tipos;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public class ParticipacaoPosGraduando extends Participacao{
	private String nivel;
	
	public ParticipacaoPosGraduando(Projeto projeto, Pessoa pessoa, int horasSemanais, double valorHora, String nivel) {
		super(projeto, pessoa, horasSemanais, valorHora);
		
		setNivel(nivel);
		
		if (!(projeto instanceof Ped || projeto instanceof Extensao)){
			throw new CpcException("Tipo de projeto invalido para pos graduando");
		}
	}
	
	public String getNivel(){
		return nivel;
	}
	
	public void setNivel(String nivel){
		ValidateUtil.validaString(nivel, "Nivel nulo ou vazio");
		this.nivel = nivel;
	}
	
	

}
