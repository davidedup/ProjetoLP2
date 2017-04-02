package br.edu.ufcg.projetolp2.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.edu.ufcg.projetolp2.exceptions.LoggingException;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.util.IO;

public class GeradorRelatorio {
	
	public void geraRelatorioProjetos(List<Projeto> projetos) throws LoggingException {
		
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
		
		try {
			FileWriter fw = new FileWriter("cad_projetos.txt");
			fw.write(output);
			fw.close();
		} catch (IOException e) {
			throw new LoggingException(e, "Ocorreu um erro ao gerar relatorio de projetos");
		}
		
	}
	
	public void geraRelatorioColaboracoes () throws LoggingException {
		
	}
	
}
