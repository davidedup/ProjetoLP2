package br.edu.ufcg.projetolp2.model.pessoa;

/**
 * Classe que representa uma Pessoa para o sistema.
 * Uma pessoa é composta por atributos: nome, email e cpf.
 * @author Juan
 *
 */
public class Pessoa {

	private String nome;

	private String email;

	private String cpf;

	public Pessoa(String nome, String email, String cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome){
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

}