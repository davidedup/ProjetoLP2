package br.edu.ufcg.projetolp2.controllers;
import java.util.HashMap;
import java.util.Map;

import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;

public class PessoaController {
	private Map<String, Pessoa> pessoas;
	private int codigoAtual;
	
	public PessoaController() {
		pessoas = new HashMap<String, Pessoa>();
		codigoAtual = 100;
	}
	

	public String cadastraPessoa(String cpf, String nome, String email) {
		Pessoa pessoa = new Pessoa(nome, email, cpf);
		String codigo = Integer.toString(codigoAtual++);
		pessoas.put(codigo, pessoa);
		
		return codigo;
	}

	public void editaNome(String cpf, String nome) {
		Pessoa pessoa = encontraPessoa(cpf);
		
		pessoa.setNome(nome);
	}

	public void editaEmail(String cpf, String email) {
		Pessoa pessoa = encontraPessoa(cpf);
		
		pessoa.setEmail(email);
	}

	public String getNome(String cpf) {
		Pessoa pessoa = encontraPessoa(cpf);
		
		return pessoa.getNome();
	}

	public String getEmail(String cpf) {
		Pessoa pessoa = encontraPessoa(cpf);
		
		return pessoa.getEmail();
	}

	public void removePessoa(String cpf) {

	}
	
	private Pessoa encontraPessoa(String cpf){
		return pessoas.get(cpf);
	}

}
