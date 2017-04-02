package br.edu.ufcg.projetolp2.projeto;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Cooperacao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pivic;

public class PedTests {
	Ped projPivic;
	Pessoa daniel,juan;

	@Before
	public void setUp() throws Exception {
		projPivic = new Pivic(0, "as", "sao", "22/12/2012", 2, 3, 4, 5);
		daniel = new Pessoa("Daniel", "daniel@gmail.com", "111.111.111-11");
		juan = new Pessoa("juan", "juazinho@lol.com", "123.123.123-12");
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
		
		//Testar adiciona participacao de Cooperacao:
		try{
			Cooperacao c = new Cooperacao(10, "nossa", "help", "22/12/2014", 12, 8, 5, 3);
			ParticipacaoProfessor p = new ParticipacaoProfessor(c, daniel, 10, 10, true);
			c.adicionaParticipacao(p);
		}catch(ProjetoException e){
			assertEquals(e.getMessage(),"Projetos P&D nao podem ter mais de um coordenador");
		}
		
		
	}
	
	@Test
	public void testGetInfo() {
		assertEquals("3", projPivic.getInfo("producao Tecnica"));
		assertEquals("4", projPivic.getInfo("producao Academica"));
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

	@Test
	public void testSetInfo() {
		projPivic.setInfo("producao tecnica", "4");
		projPivic.setInfo("producao academica", "3");
		projPivic.setInfo("patentes", "1");
		
		assertEquals("4", projPivic.getInfo("producao tecnica"));
		assertEquals("3", projPivic.getInfo("producao Academica"));
		assertEquals("1", projPivic.getInfo("patentes"));
		
		try {
			projPivic.setInfo("", "ds");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Atributo nulo ou invalido");
		}

		try {
			projPivic.setInfo("nomeee", "osado");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Atributo nulo ou invalido");
		}
		
	}
}
