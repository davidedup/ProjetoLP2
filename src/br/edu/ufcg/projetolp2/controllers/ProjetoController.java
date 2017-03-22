package br.edu.ufcg.projetolp2.controllers;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.ValidationException;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.exceptions.FactoryException;
import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;
import br.edu.ufcg.projetolp2.util.DateUtil;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public class ProjetoController {

	private Map<Integer, Projeto> projetos;
	private PedFactory pedFactory;
	private int ultimoCodigo;

	public ProjetoController() {
		ultimoCodigo = 0;
		projetos = new HashMap<Integer, Projeto>();
		pedFactory = new PedFactory();
	}

	/**
	 * Cria uma monitoria e retorna seu codigo
	 * 
	 * @param nome
	 *            - nome do projeto
	 * @param disciplina
	 *            - disciplina que a monitoria atende
	 * @param rendimento
	 *            - rendimento que varia de 0-100%
	 * @param objetivo
	 *            - descricao do objetivo da monitoria
	 * @param periodo
	 *            - periodo no qual a monitoria esta atuando
	 * @param dataInicio
	 *            - data de inicio da monitoria
	 * @param duracao
	 *            - duracao em meses da monitoria
	 * @return o codigo da monitoria adicionada
	 */
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo,
			String dataInicio, int duracao) {

		try {
			Projeto projeto = new Monitoria(ultimoCodigo++, nome, objetivo, dataInicio, duracao, disciplina, periodo,
					rendimento);
			projetos.put(projeto.getCodigo(), projeto);

			return projeto.getCodigo();
		} catch (ValidacaoException | ParseException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}

	}

	/**
	 * Cria um projeto do tipo PET e retorna seu codigo
	 * 
	 * @param nome
	 *            - nome do projeto PET
	 * @param objetivo
	 *            - descricao do objetivo do projeto PET
	 * @param impacto
	 *            - varia de 1 a 6 e depende da quantidade de pessoas atingidas:
	 *            1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do
	 *            estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil),
	 *            6 - federacao (Brasil)
	 * @param rendimento
	 *            - rendimento que varia de 0-100%
	 * @param prodTecnica
	 *            - quatidade de producoes tecnicas
	 * @param prodAcademica
	 *            - quantidade de procucoes academicas
	 * @param patentes
	 *            - quantidades de patentes
	 * @param dataInicio
	 *            - data em que o projeto comecou
	 * @param duracao
	 *            - duracoa em meses do projeto
	 * @return - o codigo do projeto adicionado
	 */
	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica,
			int prodAcademica, int patentes, String dataInicio, int duracao) throws CpcException {
		try {
			Projeto projeto = new Pet(ultimoCodigo++, nome, objetivo, dataInicio, duracao, impacto, prodTecnica,
					prodAcademica, patentes, rendimento);
			projetos.put(projeto.getCodigo(), projeto);

			return projeto.getCodigo();
		} catch (ValidacaoException | ParseException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}

	}

	/**
	 * Cria um projeto do tipo P&D e retorna seu codigo
	 * 
	 * @param nome
	 *            do projeto do tipo P&D
	 * @param categoria
	 *            - Determina a categoria do projeto Cooperacao, PIBIC,PIBITI ou
	 *            PIVIC
	 * @param prodTecnica
	 *            - quatidade de producoes tecnicas
	 * @param prodAcademica
	 *            - quantidade de procucoes academicas
	 * @param patentes
	 *            - quantidades de patentes
	 * @param objetivo
	 *            - descreve o objetivo do projeto
	 * @param dataInicio
	 *            - data em que o projeto comecou
	 * @param duracao
	 *            - duracao em meses do projeto
	 * @return - o codigo do projeto adicionado
	 */
	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes,
			String objetivo, String dataInicio, int duracao) {
		try {
			Projeto projeto = pedFactory.create(ultimoCodigo++, nome, categoria, prodTecnica, prodAcademica, patentes,
					objetivo, dataInicio, duracao);
			projetos.put(projeto.getCodigo(), projeto);
			return projeto.getCodigo();
		} catch (FactoryException | ParseException | ValidacaoException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}

	}

	/**
	 * Cria um projeto do tipo extens�o e retorna seu codigo
	 * 
	 * @param nome
	 *            - nome do projeto de exens�o
	 * @param objetivo
	 *            - descricao do obejtivo do projeto
	 * @param impacto
	 *            - varia de 1 a 6 e depende da quantidade de pessoas atingidas:
	 *            1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do
	 *            estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil),
	 *            6 - federacao (Brasil)
	 * @param dataInicio
	 *            - data em que o projeto come�ou
	 * @param duracao
	 *            -duracao em meses do projeto
	 * @return - codigo do projeto adicionado
	 */
	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		try {
			Projeto projeto = new Extensao(ultimoCodigo++, nome, objetivo, dataInicio, duracao, impacto);
			projetos.put(projeto.getCodigo(), projeto);

			return projeto.getCodigo();
		} catch (ParseException | ValidacaoException | ProjetoException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}

	}

	/**
	 * remove o projeto, dado seu codigo
	 * 
	 * @param codigo
	 *            - codigo do projeto a ser removido
	 */
	public void removeProjeto(int codigo) {
		Projeto projeto = this.getProjeto(codigo);
		projetos.remove(codigo, projeto);
	}

	/**
	 * Método que retorna uma string contendo determinada informação do projeto
	 * 
	 * @param codigo
	 *            - código do projeto a ser buscado
	 * @param atributo
	 *            - nome do atributo a ser retornado
	 * @return valor dado ao determinado atributo do determinado projeto
	 */
	public String getInfoProjeto(int codigo, String atributo) {
		Projeto projeto = this.getProjeto(codigo);

		try {
			return projeto.getInfo(atributo);
		} catch (ProjetoException | ValidacaoException e) {
			throw new CpcException(e, "Erro na consulta de projeto: " + e.getMessage());
		}
	}

	/**
	 * Método que edita um determinado valor de um atributo de um projeto
	 * 
	 * @param codigo
	 *            - código do projeto a ser buscado
	 * @param atributo
	 *            - atributo do projeto a ser modificado
	 * @param valor
	 *            - novo valor a ser atribuido
	 */
	public void editaProjeto(int codigo, String atributo, String valor) {
		Projeto projeto = getProjeto(codigo);
		try {
			projeto.setInfo(atributo, valor);
		} catch (ProjetoException | ValidacaoException e) {
			throw new CpcException(e, "Erro na atualizacao de projeto: " + e.getMessage());
		}
	}

	/**
	 * Método responsável por remover a participação de uma pessoa de um projeto
	 * 
	 * @param cpfPessoa
	 *            - CPF da pessoa a ser desassociada do projeto
	 * @param codProjeto
	 *            - código do projeto o qual a pessoa deve ser desassociado
	 */
	public void removeParticipacao(String cpfPessoa, int codProjeto) {
		Projeto projeto = getProjeto(codProjeto);
		try {
			projeto.removeParticipacao(cpfPessoa);
		} catch (ProjetoException | ValidacaoException e) {
			throw new CpcException(e, "Erro na remocao de participacao: " + e.getMessage());
		}
	}

	/**
	 * Método que remove todas as participações de uma pessa de todos os
	 * projetos
	 * 
	 * @param cpfPessoa
	 *            - CPF da pessoa a ter todas as suas participações removidas
	 */
	public void removeParticipacao(String cpfPessoa) {
		try {
			for (Integer i : projetos.keySet()) {
				projetos.get(i).removeParticipacao(cpfPessoa);
			}
		} catch (ProjetoException | ValidacaoException e) {
			throw new CpcException(e, "Erro na remocao de participacao: " + e.getMessage());
		}
	}

	/**
	 * Método que adiciona uma nova participação de uma pessoa em um determinado
	 * projeto.
	 * 
	 * @param participacao
	 *            - objeto participação a ser adicionado
	 */
	public void adicionaParticipacao(Participacao participacao) {
		try {
			Projeto projeto = getProjeto(participacao.getProjeto().getCodigo());
			projeto.adicionaParticipacao(participacao);
		} catch (ProjetoException | ValidacaoException e) {
			throw new CpcException(e, "Erro na associacao de pessoa a projeto: " + e.getMessage());
		}
	}

	/**
	 * Método que retorna o código de um projeto dado o seu nome.
	 * 
	 * @param nome
	 *            - nome do projeto a ser buscado
	 * @return inteiro representando o código do objeto buscado
	 */
	public int getCodigoProjeto(String nome) {
		try {
			return getProjeto(nome).getCodigo();
		} catch (ProjetoException | ValidacaoException e) {
			throw new CpcException(e, "Erro na obtencao de codigo de projeto: Projeto nao encontrado");
		}
	}

	/**
	 * Recupera o projeto, dado seu codigo
	 * 
	 * @param codigo
	 *            - codigo do projeto
	 * @return - objeto Projeto requisitado
	 */
	public Projeto getProjeto(int codigo) {
		if (projetos.containsKey(codigo))
			return projetos.get(codigo);
		else
			throw new ProjetoException("Erro na consulta de projeto: Projeto nao encontrado");
	}

	/**
	 * Método que retorna um projeto dado o seu nome
	 * 
	 * @param nomeProjeto
	 *            - nome do projeto a ser buscado
	 * @return objeto projeto buscado
	 */
	public Projeto getProjeto(String nomeProjeto) {
		Set<Integer> codigos = projetos.keySet();
		for (Integer codigo : codigos) {
			Projeto projeto = projetos.get(codigo);
			if (projeto.getNome().equalsIgnoreCase(nomeProjeto))
				return projeto;
		}
		throw new ProjetoException("Erro na consulta de projeto: Projeto nao encontrado");
	}

}
