package br.edu.ufcg.projetolp2.logging;

import java.util.List;

import br.edu.ufcg.projetolp2.model.UASCGastos;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.util.DateUtil;
import br.edu.ufcg.projetolp2.util.IO;

public class GeradorRelatorio {
	
	public String geraRelatorioProjetos(List<Projeto> projetos) {
		
		projetos.sort(null);
		int posGraduandos = 0;
		int graduandos = 0;
		int profissionais = 0;
		int concluidos = 0;
		String output = String.format("Cadastro de Projetos: %d projetos registrados%s", projetos.size(), IO.NL);
		
		for (int i = 1; i <= projetos.size(); i++) {
			Projeto projeto = projetos.get(i - 1);
			posGraduandos += projeto.getTotalParticipacoesPosGraduando();
			graduandos += projeto.getTotalParticipacoesGraduando();
			profissionais += projeto.getTotalParticipacoesProfissional();
			concluidos += projeto.isEmAndamento()? 0 : 1;
			output += "==> Projeto " + i + ":" + IO.NL;
			output += projeto.toString() + IO.NL + IO.NL;
		}
		
		output += String.format("Total de projetos concluidos: %d" + IO.NL
				+ "%% Participacao da graduacao: %d" + IO.NL
				+ "%% Participacao da pos-graduacao: %d" + IO.NL
				+ "%% Participacao de profissionais: %d",
				concluidos, graduandos, posGraduandos, profissionais);

		return output;
	}
	
	public String geraRelatorioColaboracoes(List<Projeto> projetos, UASCGastos uasc) {
		
		String output = "Historico das colaboracoes:" + IO.NL;
		double totalColaborado = 0;
		double totalGasto = 0;
		double totalEmCaixa = 0;
		
		for (Projeto projeto : projetos) {
			totalColaborado += projeto.calculaColaboracao();
			totalEmCaixa += projeto.calculaBemCapital();
			output += String.format("==> Nome: %s Data de inicio: %s Valor colaborado: R$ %.2f%s", 
					projeto.getNome(), DateUtil.formatDate(projeto.getDataInicio()), projeto.calculaColaboracao(), IO.NL);
		}
		
		output += String.format("Total acumulado com colaboracoes: R$ %.2f" + IO.NL
				+ "Total gasto: R$ %.2f" + IO.NL
				+ "Total em caixa: R$ %.2f", totalColaborado, uasc.getDebito(), uasc.getTotal());
		
		return output;
	}
}
