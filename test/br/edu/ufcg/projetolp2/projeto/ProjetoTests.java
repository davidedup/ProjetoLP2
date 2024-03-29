package br.edu.ufcg.projetolp2.projeto;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pivic;

public class ProjetoTests {
	
	Projeto projExt;
	Projeto projMon;
	Projeto projPet;
	Projeto projCoop;
	Projeto projPibiti;

	@Before
	public void setUp() throws Exception {
		PedFactory factory  = new PedFactory();
		projPet = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 5, 6, 8, 8, 2, 8);
		projCoop = factory.create(112, "coop", "coop", 3, 3, 3, "sSHSAO", "12/12/2011", 1);
		projPibiti = factory.create(111, "pibiti", "pibiti", 1, 2, 3, "12OSHSAO", "14/12/2012", 2);
		projMon = new Monitoria(1, "Monitoria", "monitorar", "10/02/2019", 1, "P2", "1232.2", 1);			
		projExt = new Extensao(1, "Extensao", "objetivo", "10/02/2019", 2, 1);
	}

	@Test
	public void testProjeto() {
		try{
			projPet = new Pet(0, "", "Levar os jovens a olimpiada", "10/02/2019", 5, 6, 8, 8, 2, 8);
			fail();
		} catch(Exception e){
			assertEquals(e.getMessage(), "Nome nulo ou vazio");
		}
		
		try{
			projPet = new Pet(0, "Adasd", "", "10/02/2019", 1, 6, 8, 8, 2, 8);
			fail();
		} catch(Exception e){
			assertEquals(e.getMessage(), "Objetivo nulo ou vazio");
		}
		
		try{
			projPet = new Pet(0, "asas", "lim", "10/02/2019", -1, 6, 8, 8, 2, 8);
			fail();
		} catch(Exception e){
			assertEquals(e.getMessage(), "Duracao invalida");
		}
		
	}

	@Test
	public void testAddCusto() {
		//TODO
	}

	@Test
	public void testGetParticipacoes() {
		Pessoa pessoa = new Pessoa("Nuj", "juan@gmail.com", "219.114.442-44");
		assertEquals("", projCoop.getInfo("participacoes"));
		projCoop.adicionaParticipacao(new ParticipacaoGraduando(projCoop, pessoa, 3, 3));
		assertEquals("Nuj", projCoop.getInfo("participacoes"));
		pessoa = new Pessoa("CA", "juan@gmail.com", "219.114.442-44");
	}

	@Test
	public void testRemoveParticipacao() {
		Pessoa pessoa = new Pessoa("Nuj", "juan@gmail.com", "219.114.442-44");
		projCoop.adicionaParticipacao(new ParticipacaoGraduando(projCoop, pessoa, 3, 3));
		pessoa = new Pessoa("CA", "juan@gmail.com", "219.114.442-14");
		projCoop.adicionaParticipacao(new ParticipacaoGraduando(projCoop, pessoa, 3, 3));
		assertEquals("CA, Nuj", projCoop.getInfo("participacoes"));
		
		projCoop.removeParticipacao("219.114.442-44");
		assertEquals("CA", projCoop.getInfo("participacoes"));
	}

	@Test
	public void testAdicionaParticipacao() {
		Pessoa pessoa = new Pessoa("Nuj", "juan@gmail.com", "219.114.442-44");
		projCoop.adicionaParticipacao(new ParticipacaoGraduando(projCoop, pessoa, 3, 3));
		assertEquals("Nuj", projCoop.getInfo("participacoes"));
		pessoa = new Pessoa("CA", "juan@gmail.com", "219.114.442-44");
	}

	@Test
	public void testEqualsObject() throws ParseException {
		Projeto projPetAux = new Pet(0, "OPI", "Levar os jovens a olimpiada", "28/02/1997", 5, 6, 8, 8, 2, 8);
		assertNotEquals(projCoop, projExt);
		assertEquals(projPetAux, projPet);
		projPetAux = new Pet(2, "OPI", "Levar os jovens a olimpiada", "28/02/1997", 5, 6, 8, 8, 2, 8);
		assertNotEquals(projCoop, projPetAux);
	}

	@Test
	public void testSetInfo() {
		try {
			projCoop.setInfo("data de inicio", "10/02/19");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}
		try {
			projCoop.setInfo("data de inicio", "1010/02/1978");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}
		try {
			projCoop.setInfo("data de inicio", "10/0200/1978");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}
		try {
			projCoop.setInfo("data de inicio", "10/13/1920");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}
		try {
			projCoop.setInfo("data de inicio", "32/02/1920");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}
		try {
			projCoop.setInfo("data de inicio", "01.02.2017");
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}

	
	}
}
