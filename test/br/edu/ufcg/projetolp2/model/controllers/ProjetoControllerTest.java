package br.edu.ufcg.projetolp2.model.controllers;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.controllers.ProjetoController;
import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.util.DateUtil;

public class ProjetoControllerTest {
	private Projeto projeto;
	private ProjetoController controller;

	@Before
	public void setUp() throws Exception {
		controller = new ProjetoController();
		int codProjeto = controller.adicionaMonitoria("Monitoria de P2", "Programacao 2", 
				100, "Auxiliar no ensino da disciplina de Programacao 2",
				"2016.2", "01/01/2017", 6);
		projeto = controller.getProjeto(codProjeto);
	}

	@Test
	public void testAdicionaMonitoria() throws ParseException {
		String nome = "Monitorando";
		String disciplina = "Prog1";
		int rendimento = 90;
		String objetivo = "Auxiliar os alunos(as) em P1";
		String periodo = "2016.1";
		String dataInicio = "23/12/2016";
		int duracao = 9;
		int cod = controller.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
		
		assertEquals(controller.getNome(cod), nome);
		assertEquals(controller.getDataInicio(cod), DateUtil.parseDate(dataInicio));
		assertEquals(controller.getDuracao(cod), duracao);
		assertEquals(controller.getObjetivo(cod), objetivo);
		
		
		try{
			controller.adicionaMonitoria("", disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
		}catch(CpcException e){
			assertEquals(e.getMessage(), "Erro no cadastro de projeto: Nome nulo ou vazio");
		}
		
		try{
			controller.adicionaMonitoria(nome, "", rendimento, objetivo, periodo, dataInicio, duracao);
		}catch(CpcException e){
			assertEquals(e.getMessage(), "Erro no cadastro de projeto: Nome nulo ou vazio");
		}
		
	}

	@Test
	public void testAdicionaPET() throws ParseException {
		String nome = "PET Computacao";
		String objetivo = "Objetivo generico";
		int impacto = 1;
		int rendimento = 80;
		int prodTecnica = 1;
		int prodAcademica = 2;
		int patentes = 0;
		String dataInicio = "03/02/2017";
		int duracao = 12; 

		int cod = controller.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio, duracao);
	
		assertEquals(controller.getNome(cod), nome);
		assertEquals(controller.getDataInicio(cod), DateUtil.parseDate(dataInicio));
		assertEquals(controller.getDuracao(cod), duracao);
		assertEquals(controller.getObjetivo(cod), objetivo);
	}

	@Test
	public void testAdicionaPED() throws ParseException {
		String nome = "APLICACAO DA MINERACAO DE DADOS EM REPOSITORIOS DINAMICOS";
		String categoria = "PIBITI";
		int prodTecnica = 2;
		int prodAcademica = 4;
		int patentes = 1;
		String objetivo = "Desenvolvimento tecnologico e inovacao";
		String dataInicio = "01/01/2017";
		int duracao = 24;

		int cod = controller.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
	
		assertEquals(controller.getNome(cod), nome);
		assertEquals(controller.getDataInicio(cod), DateUtil.parseDate(dataInicio));
		assertEquals(controller.getDuracao(cod), duracao);
		assertEquals(controller.getObjetivo(cod), objetivo);
	}

	@Test
	public void testAdicionaExtensao() throws ParseException {
		String nome = "Projeto olimpico";
		String objetivo = "Ganhar medalhas de ouro";
		int impacto = 4;
		String dataInicio = "02/03/2017";
		int duracao = 16;
		int cod = controller.adicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);

		assertEquals(controller.getNome(cod), nome);
		assertEquals(controller.getDataInicio(cod), DateUtil.parseDate(dataInicio));
		assertEquals(controller.getDuracao(cod), duracao);
		assertEquals(controller.getObjetivo(cod), objetivo);
	}

	@Test
	public void testGetNome() {
		assertEquals(controller.getNome(projeto.getCodigo()), projeto.getNome() );
	}

	@Test
	public void testGetObjetivo() {
		assertEquals(controller.getObjetivo(projeto.getCodigo()), projeto.getObjetivo());
	}

	@Test
	public void testGetDataInicio() {
		assertEquals(controller.getDataInicio(projeto.getCodigo()), projeto.getDataInicio());
	}

	@Test
	public void testGetDuracao() {
		assertEquals(controller.getDuracao(projeto.getCodigo()), projeto.getDuracao());
	}

	@Test
	public void testEditaObjetivo() {
		controller.editaObjetivo(projeto.getCodigo(), "NOVOOBJETIVO");
		assertEquals(projeto.getObjetivo(), "NOVOOBJETIVO");
	}

	@Test
	public void testEditaNome() {
		controller.editaNome(projeto.getCodigo(), "NOVONOME");
		assertEquals(projeto.getNome(), "NOVONOME");
	}

	@Test
	public void testEditaDuracao() {
		controller.editaDuracao(projeto.getCodigo(), 1111);
		assertEquals(projeto.getDuracao(), 1111);
	}

	@Test
	public void testEditaDataInicio() throws ParseException {
		Date data = DateUtil.parseDate("11/12/1993");
		controller.editaDataInicio(projeto.getCodigo(), data);
		assertEquals(projeto.getDataInicio(), data);
	}

	@Test
	public void testRemoveProjeto() {
		controller.removeProjeto(projeto.getCodigo());
		try{
			controller.getProjeto(projeto.getCodigo());
			fail("Encontrou projeto removido");
		} catch(CpcException e){
			assertEquals("Erro na consulta de projeto: Projeto nao encontrado", e.getMessage());
		}
	}

	@Test
	public void testGetProjeto() {
		assertEquals(controller.getProjeto(projeto.getCodigo()), projeto);
	}

}
