package br.edu.ufcg.projetolp2.projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;

public class MonitoriaTests {

	Projeto projMon;

	@Before
	public void setUp() throws Exception {
		projMon = new Monitoria(1, "Monitoria", "monitorar", "10/02/2019", 1, "P2", "1232.2", 1);
	}
	
	@Test
	public void testMonitoria() {
		try{
			new Monitoria(1, "Monitoria", "monitorar", "10/02/2019", 1, "", "1232.2", 1);
			fail();
		} catch(Exception e){
			assertEquals("Disciplina nula ou vazia", e.getMessage());
		}
		
		try{
			new Monitoria(1, "Monitoria", "monitorar", "10/02/2019", 1, "da", "", 1);
			fail();
		} catch(Exception e){
			assertEquals("Periodo nulo ou vazio", e.getMessage());
		}
		
		try{
			new Monitoria(1, "Monitoria", "monitorar", "10/02/2019", 1, "", "1232.2", -1);
			fail();
		} catch(Exception e){
			assertEquals("Rendimento invalido", e.getMessage());
		}
	}

	@Test
	public void testGetInfo() {
		assertEquals(projMon.getInfo("disciplina"), "P2");
		assertEquals(projMon.getInfo("periodo"), "1232.2");
		assertEquals(projMon.getInfo("rendimento"), "1");
		
		try {
			projMon.getInfo("producao academica");
		} catch (Exception e) {
			assertEquals("Monitoria nao possui Producao academica", e.getMessage());
		}
	}

	@Test
	public void testSetInfo() {
		projMon.setInfo("disciplina", "P3");
		assertEquals(projMon.getInfo("disciplina"), "P3");
		projMon.setInfo("periodo", "2012.2");
		assertEquals(projMon.getInfo("periodo"), "2012.2");
		projMon.setInfo("rendimento", "2");
		assertEquals(projMon.getInfo("rendimento"), "2");
	}

}
