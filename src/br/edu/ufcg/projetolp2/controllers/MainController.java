package br.edu.ufcg.projetolp2.controllers;

import java.text.ParseException;
import java.util.Date;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.util.DateUtil;

public class MainController {

	private PessoaController pessoaController;
	private ProjetoController projetoController;
	private ParticipacaoController participacaoController;
	
	public MainController () {
		projetoController = new ProjetoController();
	}

	public void iniciaSistema() {

	}

	public void fechaSistema() {

	}

	public String cadastraPessoa(String cpf, String nome, String email) {
		return null;
	}

	public void editaPessoa(String cpf, String atributo, String valor) {

	}

	public String getInfoPessoa(String cpf, String atributo) {
		return null;
	}

	public void removePessoa(String cpf) {

	}

	public void adicionaParticipacao(int codigoProjeto, String cpf, Date dataInicio, int duracao, int horasSemanais, double valorHora) {
		
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
	 * @param impacto - varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade acad�mica, 2 - cidade, 3 - regi�o (dentro do estado), 4 - estado, 5 - regi�o (dentro da federa��o/Brasil), 6 - federa��o (Brasil)
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
		return projetoController.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
	}

	/**
	 * Cria um projeto do tipo extens�o e retorna seu codigo
	 * @param nome - nome do projeto de exens�o
	 * @param objetivo - descricao do obejtivo do projeto
	 * @param impacto -  * @param impacto - varia de 1 a 6  e depende da quantidade de pessoas atingidas: 1 - comunidade acad�mica, 2 - cidade, 3 - regi�o (dentro do estado), 4 - estado, 5 - regi�o (dentro da federa��o/Brasil), 6 - federa��o (Brasil)
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
		if (atributo.equalsIgnoreCase("nome")){
			return projetoController.getNome(cod);
		}else if(atributo.equalsIgnoreCase("objetivo")){
			return projetoController.getObjetivo(cod);
		}else if(atributo.equalsIgnoreCase("Data de inicio")){
			try {
				return DateUtil.formatDate(projetoController.getDataInicio(cod));
			} catch (ParseException e) {
				throw new CpcException(e, "Data invalida");
			}	
		}else{
			return "" + projetoController.getDuracao(cod);
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
		}else{
			projetoController.editaDuracao(codigo, Integer.parseInt(valor));
		}
	}

	/**
	 * Remove um projeto com base em seu codigo
	 * @param codigo - codigo do projeto a ser removido
	 */
	public void removeProjeto(int codigo) {
		projetoController.removeProjeto(codigo);
	}

	public void associaProfessor(String cpfPessoa, int codigoProjeto, boolean coordenador, double valorHora, int qntHoras) {

	}

	public void associaGraduando(String cpfPessoa, int codigoProjeto, double valorHora, int qntHoras) {

	}

	public void associaProfissional(String cpfPessoa, int codigoProjeto, String cargo, double valorHora, int qntHoras) {

	}

	public void removeParticipacao(String cpfPessoa, int codigoProjeto) {

	}

}
