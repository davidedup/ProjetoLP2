package br.edu.ufcg.projetolp2.projeto;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Pet;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;

public class ProjetoTests {
	
	Projeto projExt;
	Projeto projMon;
	Projeto projPet;
	Projeto projCoop;
	Projeto projPibiti;
	Projeto projPibic;

	@Before
	public void setUp() throws Exception {
		PedFactory factory  = new PedFactory();
		projPet = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 5, 8, 8, 8, 2, 8);
		projCoop = factory.create(112, "coop", "coop", 3, 3, 3, "sSHSAO", "12/12/2011", 1);
		projPibic = factory.create(113, "pibic", "pibic", 1, 2, 3, "OSHSAbO", "11/12/2012", 2);
		projPibiti = factory.create(111, "pibiti", "pibiti", 1, 2, 3, "12OSHSAO", "14/12/2012", 2);
		projMon = new Monitoria(1, "Monitoria", "monitorar", "10/02/2019", 1, "P2", "1232.2");
		projExt = new Extensao(1, "Extensao", "objetivo", "10/02/2019", 2, 1);
	}

	@Test
	public void testProjeto() {
		try{
			projPet = new Pet(0, "", "Levar os jovens a olimpiada", new Date(), 5, 8, 8, 8, 2, 8);
			fail();
		} catch(CpcException e){
			assertEquals(e.getMessage(), "Nome nulo ou vazio");
		}
		
		try{
			projPet = new Pet(0, "Adasd", "", new Date(), 1, 8, 8, 8, 2, 8);
			fail();
		} catch(CpcException e){
			assertEquals(e.getMessage(), "Objetivo nulo ou vazio");
		}
		
		try{
			projPet = new Pet(0, "asas", "lim", new Date(), -1, 8, 8, 8, 2, 8);
			fail();
		} catch(CpcException e){
			assertEquals(e.getMessage(), "Duracao invalida");
		}
		
	}

	@Test
	public void testAddCusto() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParticipacoes() {
		Pessoa pessoa = new Pessoa("Nuj", "juan@gmail.com", "219.114.442-44");
		assertEquals("", projCoop.getInfo("participacoes"));
		projCoop.adicionaParticipacao(new Participacao(projCoop, pessoa, 3, 3, new ParticipacaoGraduando()));
		assertEquals("Nuj", projCoop.getInfo("participacoes"));
		pessoa = new Pessoa("CA", "juan@gmail.com", "219.114.442-44");
		projCoop.adicionaParticipacao(new Participacao(projCoop, pessoa, 3, 3, new ParticipacaoGraduando()));
		assertEquals("Nuj, CA", projCoop.getInfo("participacoes"));
	}

	@Test
	public void testRemoveParticipacao() {
		Pessoa pessoa = new Pessoa("Nuj", "juan@gmail.com", "219.114.442-44");
		projCoop.adicionaParticipacao(new Participacao(projCoop, pessoa, 3, 3, new ParticipacaoGraduando()));
		pessoa = new Pessoa("CA", "juan@gmail.com", "219.114.442-14");
		projCoop.adicionaParticipacao(new Participacao(projCoop, pessoa, 3, 3, new ParticipacaoGraduando()));
		assertEquals("Nuj, CA", projCoop.getInfo("participacoes"));
		
		projCoop.removeParticipacao("219.114.442-44");
		assertEquals("CA", projCoop.getInfo("participacoes"));
	}

	@Test
	public void testAdicionaParticipacao() {
		Pessoa pessoa = new Pessoa("Nuj", "juan@gmail.com", "219.114.442-44");
		projCoop.adicionaParticipacao(new Participacao(projCoop, pessoa, 3, 3, new ParticipacaoGraduando()));
		assertEquals("Nuj", projCoop.getInfo("participacoes"));
		pessoa = new Pessoa("CA", "juan@gmail.com", "219.114.442-44");
		projCoop.adicionaParticipacao(new Participacao(projCoop, pessoa, 3, 3, new ParticipacaoGraduando()));
		assertEquals("Nuj, CA", projCoop.getInfo("participacoes"));
	}

	@Test
	public void testEqualsObject() {
		Projeto projPetAux = new Pet(0, "OPI", "Levar os jovens a olimpiada", new Date(), 5, 8, 8, 8, 2, 8);
		assertNotEquals(projCoop, projExt);
		assertEquals(projPetAux, projPet);
		projPetAux = new Pet(2, "OPI", "Levar os jovens a olimpiada", new Date(), 5, 8, 8, 8, 2, 8);
		assertNotEquals(projCoop, projPetAux);
	}

	@Test
	public void testSetInfo() {
		try {
			projCoop.setInfo("data de inicio", "10/02/19");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}
		try {
			projCoop.setInfo("data de inicio", "1010/02/1978");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}
		try {
			projCoop.setInfo("data de inicio", "10/0200/1978");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}
		try {
			projCoop.setInfo("data de inicio", "10/13/1920");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}
		try {
			projCoop.setInfo("data de inicio", "32/02/1920");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}
		try {
			projCoop.setInfo("data de inicio", "01.02.2017");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Formato de data invalido");
		}

	
	}
}
