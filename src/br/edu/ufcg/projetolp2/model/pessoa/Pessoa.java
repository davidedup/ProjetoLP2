package br.edu.ufcg.projetolp2.model.pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.Atributavel;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Cooperacao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pibic;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pibiti;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pivic;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

/**
 * Classe que representa uma Pessoa para o sistema. Uma pessoa é composta por
 * atributos: nome, email e cpf.
 * 
 * @author Juan
 *
 */
public class Pessoa implements Atributavel, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String email;
	private String cpf;
	private List<Participacao> participacoes;

	public Pessoa(String nome, String email, String cpf) throws ValidacaoException {
		setNome(nome);
		setEmail(email);
		ValidateUtil.validaCpf(cpf);
		this.cpf = cpf;
		this.participacoes = new ArrayList<Participacao>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ValidacaoException {
		ValidateUtil.validaString(nome, "Nome nulo ou vazio");
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws ValidacaoException {
		ValidateUtil.validaEmail(email);
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws ValidacaoException {
		throw new ValidacaoException("CPF nao pode ser alterado");
	}

	/**
	 * Retorna uma string contendo o nome de todos os projetos que essa pessoa
	 * participa atualmente por ordem de adição.
	 * 
	 * @return string com nome dos projetos separados por vírgula.
	 */
	public String getParticipacoes() {
		StringBuilder result = new StringBuilder();
		Iterator<Participacao> it = participacoes.iterator();
		while (it.hasNext()) {
			Participacao participacao = (Participacao) it.next();
			result.append(participacao.getProjeto().getNome());
			if (it.hasNext()) {
				result.append(", ");
			}
		}
		return result.toString();
	}

	/**
	 * Gera a pontuação total daquela pessoa de acordo com as participações em
	 * seus projetos. É feita a soma de todas as participações e é retornada a
	 * pontuação total.
	 * 
	 * @return double - total de pontos obtidos nas participações.
	 */
	public double getPontuacaoParticipacao() {
		Iterator<Participacao> it = participacoes.iterator();

		double totalPontos = 0;
		int monitoria = 0, ped = 0;
		while (it.hasNext()) {
			Participacao participacao = (Participacao) it.next();
			Projeto projeto = participacao.getProjeto();
			if (participacao.getClass() == ParticipacaoGraduando.class) {
				if (projeto.getClass() == Monitoria.class) {
					if (monitoria >= 6) {
						continue;
					}
					monitoria = (int) Math.min(6, monitoria + participacao.calculaPontos());
				} else if (projeto.getClass().getSuperclass() == Ped.class) {
					if (ped >= 8) {
						continue;
					}
					int ponto = (int) participacao.calculaPontos();
					ped = (int) Math.min(8, ped + ponto);
			} 
			} else {
				totalPontos += participacao.calculaPontos();
			}
		}

		return totalPontos + monitoria + ped;
	}

	/**
	 * Recebe um código de projeto, pesquisa e se existir, remove-o da lista de
	 * participações dessa pessoa.
	 * 
	 * @param codProjeto
	 *            - código do projeto a ser removido.
	 * @throws CpcException
	 *             - Se não for encontrado o código.
	 */
	public void removeParticipacao(int codProjeto) {
		Iterator<Participacao> it = participacoes.iterator();

		while (it.hasNext()) {
			Participacao participacao = (Participacao) it.next();
			if (participacao.getProjeto().getCodigo() == codProjeto) {
				it.remove();
				return;
			}
		}

		throw new CpcException("Pessoa nao possui participacao no projeto indicado");
	}

	/**
	 * Recebe um objeto Participacao e o adiciona na lista de participações da
	 * pessoa.
	 * 
	 * @param participacao
	 *            - a ser associado.
	 */
	public void adicionaParticipacao(Participacao participacao) {
		participacoes.add(participacao);
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

	/**
	 * Recebe um campo atributo a ser pesquisado o valor. Se o campo existir e
	 * for possível visualizar, é retornado a String correspondente ao atributo.
	 * 
	 * @return result - string correspondente ao campo específico.
	 * @throws CpcException
	 */
	@Override
	public String getInfo(String atributo) throws CpcException {
		if (atributo.equalsIgnoreCase("nome")) {
			return getNome();
		} else if (atributo.equalsIgnoreCase("cpf")) {
			return getCpf();
		} else if (atributo.equalsIgnoreCase("email")) {
			return getEmail();
		} else if (atributo.equalsIgnoreCase("participacoes")) {
			return getParticipacoes();
		} else {
			throw new CpcException("Campo invalido");
		}
	}

	/**
	 * Recebe um campo atributo a ser trocado de valor. Se o campo obdecer ao
	 * formato e for possível trocar, é feito a troca, senão é lançada uma
	 * exception
	 * 
	 * @throws CpcException
	 */
	@Override
	public void setInfo(String atributo, String valor) throws CpcException {
		try {
			if (atributo.equalsIgnoreCase("nome")) {
				setNome(valor);
			} else if (atributo.equalsIgnoreCase("cpf")) {
				setCpf(valor);
			} else if (atributo.equalsIgnoreCase("email")) {
				setEmail(valor);
			} else {
				throw new CpcException("Campo invalido");
			}
		} catch (ValidacaoException e) {
			throw new CpcException(e.getMessage());
		}

	}

	public double getValorBolsa() {
		Iterator<Participacao> it = participacoes.iterator();

		double res = 0;
		while (it.hasNext()) {
			Participacao participacao = (Participacao) it.next();

			res += participacao.getProjeto().calculaValorBolsa(participacao);
		}

		return Math.max(res, 350);
	}
}