package br.edu.ufcg.projetolp2.projeto;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pivic;

public class PetTests {
	
	Pet proj;

	@Before
	public void setUp() throws Exception {
		proj = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 5, 8, 7, 8, 2, 9);
	}
	
	@Test
	public void testPet() throws ParseException {
		
		try {	
			proj = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 5, -8, 8, 8, 2, 8);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Impacto invalido");
		}
		
		try {	
			proj = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 5, 8, 8, 8, 2, 8);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Numero de producoes tecnicas invalido");
		}

		try {
			proj = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 5, 8, 8, 8, 2, 8);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Numero de producoes academicas invalido");
		}

		try {
			proj = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 5, 8, 8, 8, 2, 8);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Numero de patentes invalido");
		}
		
		try {
			proj = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 5, 8, 8, 8, 2, -9);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Rendimento invalido");
		}
			
	}
	
	@Test
	public void testGetInfo() {	
		assertEquals("7", proj.getInfo("producao Tecnica"));
		assertEquals("8", proj.getInfo("producao Academica"));
		assertEquals("2", proj.getInfo("patentes"));
		assertEquals("8", proj.getInfo("impacto"));
		assertEquals("9", proj.getInfo("rendimento"));
		
		try {
			proj.getInfo("");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Atributo nulo ou invalido");
		}

		try {
			proj.getInfo("nomeee");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Atributo nulo ou invalido");
		}

	}

	@Test
	public void testSetInfo() {
		proj.setInfo("producao tecnica", "4");
		proj.setInfo("producao academica", "3");
		proj.setInfo("patentes", "1");
		proj.setInfo("impacto", "2");
		proj.setInfo("rendimento", "9");
		
		assertEquals("4", proj.getInfo("producao tecnica"));
		assertEquals("3", proj.getInfo("producao Academica"));
		assertEquals("1", proj.getInfo("patentes"));
		assertEquals("2", proj.getInfo("impacto"));
		assertEquals("9", proj.getInfo("rendimento"));
		
		try {
			proj.setInfo("", "ds");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Atributo nulo ou invalido");
		}

		try {
			proj.setInfo("nomeee", "osado");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Atributo nulo ou invalido");
		}
		
	}
}