package br.edu.ufcg.projetolp2.controllers;
import java.util.Map;

import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;

public class PessoaController {

	private Map<String,Pessoa> pessoas;
	
	public PessoaController() {
		// TODO Auto-generated constructor stub
	}

	public String cadastraPessoa(String cpf, String nome, String email) {
		return null;
	}

	public void editaNome(String cpf, String nome) {

	}

	public void editaEmail(String cpf, String email) {

	}
	
	public void editaCpf(String cpfOld, String cpfNew){
		
	}

	public String getNome(String cpf) {
		return null;
	}

	public String getEmail(String cpf) {
		return null;
	}

	public void removePessoa(String cpf) {

	}
	
	public Pessoa getPessoa(String cpf) {
		return null;
	}

}
