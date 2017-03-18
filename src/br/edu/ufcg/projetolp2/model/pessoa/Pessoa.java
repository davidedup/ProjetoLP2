package br.edu.ufcg.projetolp2.model.pessoa;

import java.util.HashMap;
import java.util.Map;

import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.Atributavel;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;

/**
 * Classe que representa uma Pessoa para o sistema.
 * Uma pessoa é composta por atributos: nome, email e cpf.
 * @author Juan
 *
 */
public class Pessoa implements Atributavel{

	private String nome;
	private String email;
	private String cpf;
	private Map<Integer, Participacao> participacoes;

	public Pessoa(String nome, String email, String cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.participacoes = new HashMap<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ValidacaoException {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}
	
	public String getParticipacoes() {
		//TODO
		return null;
	}
	
	public double getPontuacaoParticipacao() {
		//TODO
		return 0;
	}
	
	public void removeParticipacao(int codProjeto) {
		//TODO
	}
	
	public void adicionaParticipacao(Participacao participacao) {
		//TODO
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", email=" + email + ", cpf=" + cpf + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String getInfo(String atributo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInfo(String atributo, String valor) {
		// TODO Auto-generated method stub
		
	}
}