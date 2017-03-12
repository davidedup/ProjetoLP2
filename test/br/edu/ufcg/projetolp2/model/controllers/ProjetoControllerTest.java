package br.edu.ufcg.projetolp2.model.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.controllers.ProjetoController;

public class ProjetoControllerTest {

	private ProjetoController controller;

	@Before
	public void setUp() throws Exception {
		controller = new ProjetoController();
	}

	@Test
	public void testAdicionaMonitoria() {
		String nome = "Monitorando";
		String disciplina = "Prog1";
		int rendimento = 90;
		String objetivo = "Auxiliar os alunos(as) em P1";
		String periodo = "2016.1";
		String dataInicio = "23/12/2016";
		int duracao = 9;
		int cod = controller.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
		
		assertEquals(controller.getNome(cod), nome);
		assertEquals(controller.getDataInicio(cod), dataInicio);
		assertEquals(controller.getDuracao(cod), duracao);
		assertEquals(controller.getObjetivo(cod), objetivo);
		
	}

	@Test
	public void testAdicionaPET() {
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
	}

	@Test
	public void testAdicionaPED() {
		String nome = "APLICACAO DA MINERACAO DE DADOS EM REPOSITORIOS DINAMICOS";
		String categoria = "PIBITI";
		int prodTecnica = 2;
		int prodAcademica = 4;
		int patentes = 1;
		String objetivo = "Desenvolvimento tecnologico e inovacao";
		String dataInicio = "01/01/2017";
		int duracao = 24;

		int cod = controller.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, dataInicio, duracao);
	}

	@Test
	public void testAdicionaExtensao() {
		String nome = "Projeto olimpico";
		String objetivo = "Ganhar medalhas de ouro";
		int impacto = 4;
		String dataInicio = "02/03/2017";
		int duracao = 16;
		int cod = controller.adicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);

	}

	@Test
	public void testGetNome() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetObjetivo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDataInicio() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDuracao() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditaObjetivo() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditaNome() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditaDuracao() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditaDataInicio() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveProjeto() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProjeto() {
		fail("Not yet implemented");
	}

}
