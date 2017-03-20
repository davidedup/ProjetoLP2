package br.edu.ufcg.projetolp2.projeto;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pivic;

public class PedTests {
	Ped projPivic;

	@Before
	public void setUp() throws Exception {
		projPivic = new Pivic(0, "as", "sao", "22/12/2012", 2, 3, 4, 5);
	}

	@Test
	public void testPed() throws ParseException {
		try {
			Pivic pivic = new Pivic(0, "as", "sao", "22/12/2012", 12, -2, 2, 2);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Numero de producoes tecnicas invalido");
		}

		try {
			Pivic pivic = new Pivic(0, "as", "sao", "22/12/2012", 12, 2, -2, 2);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Numero de producoes academicas invalido");
		}

		try {
			Pivic pivic = new Pivic(0, "as", "sao", "22/12/2012", 12, 2, 2, -2);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Numero de patentes invalido");
		}
	}

	@Test
	public void testGetProducaoTecnica() {
		
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
