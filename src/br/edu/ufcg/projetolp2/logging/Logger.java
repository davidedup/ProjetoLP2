package br.edu.ufcg.projetolp2.logging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import br.edu.ufcg.projetolp2.ArquivoCpc;
import br.edu.ufcg.projetolp2.exceptions.LoggingException;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;

public class Logger {
	
	private static final String PATH = "arquivos_sistema/";
	private static final String ARQUIVO_DAT = PATH + "cpc_ufcg.dat";
	
	public void salvaEstadoSistema(ArquivoCpc arquivo) throws LoggingException {
		criaDiretorioSeNaoExistir(PATH);
		File file = new File(ARQUIVO_DAT);
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file, false));
			output.writeObject(arquivo);
			output.close();
		} catch (IOException e) {
			throw new LoggingException(e, "Erro ao salvar estado do sistema");
		}
	}
	
	public void salvaRelatorios(List<Projeto> projetos) throws LoggingException {
		GeradorRelatorio rel = new GeradorRelatorio();
		String relColab = rel.geraRelatorioColaboracoes(projetos);
		String relProj = rel.geraRelatorioProjetos(projetos);
		try {
			writeStringFile(PATH + "relatorios/", "cad_projetos.txt", relProj);
			writeStringFile(PATH + "relatorios/", "cad_colaboracoes.txt", relColab);
		} catch (IOException e) {
			throw new LoggingException(e, "Erro ao gerar relatorios");
		}
	}
	
	public ArquivoCpc recuperaEstadoSistema() throws LoggingException {
		File file = new File(ARQUIVO_DAT);
		ArquivoCpc sistemaArquivo = null;
		if (file.exists() && file.canRead()) {
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
				sistemaArquivo = (ArquivoCpc) input.readObject();
				input.close();
			} catch (IOException | ClassNotFoundException e) {
				throw new LoggingException(e, "Erro ao recuperar estado do sistema");
			}
		}
		return sistemaArquivo;
	}
	
	private void writeStringFile(String path, String fileName, String output) throws IOException {
		criaDiretorioSeNaoExistir(path);
		FileWriter fw = new FileWriter(path + fileName);
		fw.write(output);
		fw.close();
	}
	
	private void criaDiretorioSeNaoExistir(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}
	
}
