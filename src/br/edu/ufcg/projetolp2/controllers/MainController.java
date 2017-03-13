package br.edu.ufcg.projetolp2.controllers;

import java.text.ParseException;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.util.DateUtil;
import br.edu.ufcg.projetolp2.util.StringUtil;

public class MainController {

	private PessoaController pessoaController;
	private ProjetoController projetoController;
	private ParticipacaoController participacaoController;
	
	public MainController () {
		projetoController = new ProjetoController();
		participacaoController = new ParticipacaoController();
		pessoaController = new PessoaController();
	}

	public void iniciaSistema() {
		
	}

	public void fechaSistema() {
	
	}

	/**
	 * Este método faz o cadastro da pessoa no sistema
	 * @param cpf - CPF é uma String unica da pessoa a ser cadastrada
	 * @param nome - Nome da Pessoa a ser cadastrada
	 * @param email - Email da pessoa a ser cadastrada 
	 * @return cpf da pessoa cadastrada
	 */
	public String cadastraPessoa(String cpf, String nome, String email) {
		return pessoaController.cadastraPessoa(cpf, nome, email);
	}

	/**
	 * Este método edita os dados da pessoa com base no atributo passado que se deseja editar, não pode editar o CPF
	 * @param cpf - CPF da pessoa a ser editada
	 * @param atributo - atributo de Pessoa que se deseja editar
	 * @param valor - Novo valor que o atributo escolhido editado irá ter
	 */
	public void editaPessoa(String cpf, String atributo, String valor) {
		if (atributo.equalsIgnoreCase("nome")){
			pessoaController.editaNome(cpf, valor);
		} else if (atributo.equalsIgnoreCase("email")){
			pessoaController.editaEmail(cpf, valor);
		} else if (atributo.equalsIgnoreCase("cpf")){
			pessoaController.editaCpf(cpf, valor);
		}
	}

	/**
	 * Este método retorna o atributo de pessoa desejado com base no valor atributo.
	 * @param cpf - CPF da pessoa que se quer a informação
	 * @param atributo - Qual o atributo de pessoa que irá ser retornardo
	 * @return pode retornar o nome ou email, ambos String
	 */
	public String getInfoPessoa(String cpf, String atributo) {
		if (atributo.equalsIgnoreCase("nome")){
			return pessoaController.getNome(cpf);
		}else{
			return pessoaController.getEmail(cpf);		
		}
	}

	/**
	 * Este método remove a pessoa portadora do CPF passado
	 * @param cpf - CPF da pessoa que se deseja remover
	 */
	public void removePessoa(String cpf) {
		pessoaController.removePessoa(cpf);
	}
	
	/**
	 * Cria uma monitoria e retorna seu codigo
	 * @param nome - nome do projeto 
	 * @param disciplina - disciplina que a monitoria atende
	 * @param rendimento - rendimento que varia de 0-100%
	 * @param objetivo - descricao do objetivo da monitoria 
	 * @param periodo - periodo no qual a monitoria esta atuando
	 * @param dataInicio - data de inicio da monitoria
	 * @param duracao - duracao em meses da monitoria 
	 * @return o codigo da monitoria adicionada
	 */
	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo, String dataInicio, int duracao) {
		return projetoController.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
	}

	/**
	 *  Cria um projeto do tipo PET e retorna seu codigo
	 * @param nome - nome do projeto PET
	 * @param objetivo - descri��o do objetivo do projeto PET
	 * @param impacto - varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil)
	 * @param rendimento - rendimento que varia de 0-100%
	 * @param prodTecnica - quatidade de produ��es tecnicas
	 * @param prodAcademica - quantidade de procu��es acad�micas
	 * @param patentes - quantidades de patentes
	 * @param dataInicio - data em que o projeto come�ou
	 * @param duracao - duracoa em meses do projeto
	 * @return - o codigo do projeto adicionado
	 */
	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao) {
		return projetoController.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
	}
	
	/**
	 * Cria um projeto do tipo P&D e retorna seu codigo
	 * @param nome do projeto do tipo P&D
	 * @param categoria - Determina a categoria do projeto Coopera��o, PIBIC,PIBITI ou PIVIC
	 * @param prodTecnica - quatidade de produ��es tecnicas
	 * @param prodAcademica - quantidade de procu��es acad�micas
	 * @param patentes - quantidades de patentes
	 * @param objetivo -  descreve o objetivo do projeto
	 * @param dataInicio - data em que o projeto come�ou
	 * @param duracao - duracao em meses do projeto
	 * @return - o codigo do projeto adicionado
	 */
	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) {
		try {
			return projetoController.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
		} catch (ValidacaoException e) {
			throw new CpcException(e, "Erro no cadastro de projeto: " + e.getMessage());
		}
	}

	/**
	 * Cria um projeto do tipo extens�o e retorna seu codigo
	 * @param nome - nome do projeto de exens�o
	 * @param objetivo - descricao do obejtivo do projeto
	 * @param impacto - varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade academica, 2 - cidade, 3 - regiao (dentro do estado), 4 - estado, 5 - regiao (dentro da federacao/Brasil), 6 - federacao (Brasil)
	 * @param dataInicio - data em que o projeto come�ou
	 * @param duracao -duracao em meses do projeto
	 * @return - codigo do projeto adicionado
	 */
	public int adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao) {
		return projetoController.adicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);
	}

	/**
	 * Recupera uma informacao do projeto com base no atributo requerido
	 * @param cod - codigo do projeto
	 * @param atributo - atributo que se deseja recuperar
	 * @return - retorna o atributo requerido no formato de String
	 */
	public String getInfoProjeto(int cod, String atributo) {
		if (StringUtil.isStringNula(atributo) || StringUtil.isStringVazia(atributo)){
			throw new CpcException("Erro na consulta de projeto: Atributo nulo ou invalido");
		}
		
		if (atributo.equalsIgnoreCase("nome")){
			return projetoController.getNome(cod);
		} else if(atributo.equalsIgnoreCase("objetivo")){
			return projetoController.getObjetivo(cod);
			
		} else if(atributo.equalsIgnoreCase("Data de inicio")){
			try {
				return DateUtil.formatDate(projetoController.getDataInicio(cod));
			} catch (ParseException e) {
				throw new CpcException(e, "Data invalida");
			}
			
		} else if(atributo.equalsIgnoreCase("duracao")){
			return "" + projetoController.getDuracao(cod);
			
		} else if(atributo.equalsIgnoreCase("disciplina")){
			return projetoController.getDisciplina(cod);
		
		} else if(atributo.equalsIgnoreCase("periodo")){
			return projetoController.getPeriodo(cod);
		
		} else if(atributo.equalsIgnoreCase("rendimento")){
			return String.valueOf(projetoController.getRendimento(cod));
			
		} else if(atributo.equalsIgnoreCase("patentes")){
			return String.valueOf(projetoController.getPatentes(cod));
			
		} else if(atributo.equalsIgnoreCase("producao academica")){
			return String.valueOf(projetoController.getProdAcademica(cod));
			
		} else if(atributo.equalsIgnoreCase("producao tecnica")){
			return String.valueOf(projetoController.getProdTecnica(cod));
			
		} else if(atributo.equalsIgnoreCase("impacto")){
			return String.valueOf(projetoController.getImpacto(cod));
		} else {
			throw new CpcException("Erro na consulta de projeto: Atributo nulo ou invalido");
		}
	}
	
	public int getCodigoProjeto(String nomeProjeto) {
		try {
			return projetoController.getProjeto(nomeProjeto).getCodigo();
		} catch (ProjetoException e) {
			throw new CpcException("Erro na consulta de projeto: ");
		}
	}

	/**
	 * Recebe o codigo e um atributo do projeto e edita uma informa��o do projeto com base no atributo requerido com um novo valor que foi recebido
	 * @param codigo - codigo do projeto a ser editado
	 * @param atributo - atributo do projeto que se deseja editar
	 * @param valor -  novo valor que o atributo requerido ser� atulizado
	 */
	public void editaProjeto(int codigo, String atributo, String valor) {
		if (atributo.equalsIgnoreCase("nome")){
			projetoController.editaNome(codigo, valor);
		}else if(atributo.equalsIgnoreCase("objetivo")){
			projetoController.editaObjetivo(codigo, valor);
		}else if(atributo.equalsIgnoreCase("Data de inicio")){
			try {
				projetoController.editaDataInicio(codigo,DateUtil.parseDate(valor));
			} catch (ParseException e) {
				throw new CpcException(e,"Erro na atualizacao de projeto: Formato de data invalido");
			}
		} else if(atributo.equalsIgnoreCase("duracao")){
			projetoController.editaDuracao(codigo, Integer.valueOf(valor));
			
		} else if(atributo.equalsIgnoreCase("disciplina")){
			projetoController.setDisciplina(codigo, valor);
		
		} else if(atributo.equalsIgnoreCase("periodo")){
			projetoController.setPeriodo(codigo, valor);
		
		} else if(atributo.equalsIgnoreCase("rendimento")){
			projetoController.setRendimento(codigo, Integer.valueOf(valor));
			
		} else if(atributo.equalsIgnoreCase("patentes")){
			projetoController.setPatentes(codigo, Integer.valueOf(valor));
			
		} else if(atributo.equalsIgnoreCase("producao academica")){
			projetoController.setProdAcademica(codigo, Integer.valueOf(valor));
			
		} else if(atributo.equalsIgnoreCase("producao tecnica")){
			projetoController.setProdTecnica(codigo, Integer.valueOf(valor));
			
		} else if(atributo.equalsIgnoreCase("impacto")){
			projetoController.editaImpacto(codigo, Integer.valueOf(valor));
		} else {
			throw new CpcException("Erro na consulta de projeto: Atributo nulo ou invalido");
		}
	}

	/**
	 * Remove um projeto com base em seu codigo
	 * @param codigo - codigo do projeto a ser removido
	 */
	public void removeProjeto(int codigo) {
		projetoController.removeProjeto(codigo);
	}
	
	/**
	 * Faz a associa��o de um professor a um projeto
	 * @param cpfPessoa - cpf da pessoa a ser associada
	 * @param codigoProjeto - projeto ao qual o professor ser� associado
	 * @param coordenador - Flag para saber se � um professor coordenador
	 * @param valorHora - valor R$ da hora do professor
	 * @param qntHoras -  quantidade de horas semanais dedicada ao projeto
	 */
	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras) {
		participacaoController.associaProfessor(pessoaController.getPessoa(cpfPessoa), projetoController.getProjeto(codigoProjeto), coordenador, valorHora, qntHoras);
	}
	
	/**
	 * Faz a associa��o de um graduando a um projeto
	 * @param cpfPessoa - cpf da pessoa a ser associada
	 * @param codigoProjeto - projeto ao qual o graduando ser� associado
	 * @param valorHora - valor R$ da hora do graduando
	 * @param qntHoras -  quantidade de horas semanais dedicadas ao projeto
	 */
	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras) {
		participacaoController.associaGraduando(pessoaController.getPessoa(cpfPessoa), projetoController.getProjeto(codigoProjeto), valorHora, qntHoras);
	}
	
	/**
	 * Faz a associa��o de um profissional a um projeto
	 * @param cpfPessoa - cpf da pessoa a ser associada
	 * @param codigoProjeto - projeto ao qual o profissional ser� associado
	 * @param cargo - cargo em que o profissional trabalha
	 * @param valorHora - valor R$ da hora do graduando
	 * @param qntHoras - quantidade de horas semanais dedicadas ao projeto
	 */
	public void associaProfissional(String cpfPessoa, int codigoProjeto, String cargo, double valorHora, int qntHoras) {
		participacaoController.associaProfissional(pessoaController.getPessoa(cpfPessoa), projetoController.getProjeto(codigoProjeto), cargo, valorHora, qntHoras);
	}

	/**
	 * remove a participa�ao de pessoa e projeto
	 * @param cpfPessoa - CPF da pessoa a ser removida a participacao
	 * @param codigoProjeto - codigo do projeto a ser removida a participacao
	 */
	public void removeParticipacao(String cpfPessoa, int codigoProjeto) {
		participacaoController.removeParticipacao(pessoaController.getPessoa(cpfPessoa));
	}
}
