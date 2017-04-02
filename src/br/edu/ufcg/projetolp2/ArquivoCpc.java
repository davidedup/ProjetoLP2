package br.edu.ufcg.projetolp2;

import java.io.Serializable;

import br.edu.ufcg.projetolp2.controllers.PessoaController;
import br.edu.ufcg.projetolp2.controllers.ProjetoController;

/**
 * Classe utilizada para salvar as instancias dos controllers
 * e recupera-las ao reiniciar o sistema.
 *
 */
public class ArquivoCpc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PessoaController pessoaController;
	private ProjetoController projetoController;
	
	public PessoaController getPessoaController() {
		return pessoaController;
	}
	
	public ArquivoCpc(PessoaController pessoaController, ProjetoController projetoController) {
		this.pessoaController = pessoaController;
		this.projetoController = projetoController;
	}
	
	public ProjetoController getProjetoController() {
		return projetoController;
	}

}
