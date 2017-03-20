package br.edu.ufcg.projetolp2.projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PedTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPed() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProducaoTecnica() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProducaoAcademica() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPatentes() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProducaoTecnica() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProducaoAcademica() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPatentes() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetInfo() {
		assertEquals("as", projPivic.getInfo("nome"));
		assertEquals("22/12/2012", projPivic.getInfo("dataInicio"));
		assertEquals("2", projPivic.getInfo("duracao"));
		assertEquals("3", projPivic.getInfo("producaoTecnica"));
		assertEquals("4", projPivic.getInfo("producaoAcademica"));
		assertEquals("5", projPivic.getInfo("patentes"));

		try {
			projPivic.getInfo("");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Atributo nulo ou invalido");
		}

		try {
			projPivic.getInfo("nomeee");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Atributo nulo ou invalido");
		}

	}

}
