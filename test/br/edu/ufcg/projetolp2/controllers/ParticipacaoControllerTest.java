package br.edu.ufcg.projetolp2.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;

public class ParticipacaoControllerTest {
	private ParticipacaoController participacaoController;

	@Before
	public void setUp() throws Exception {
		participacaoController = new ParticipacaoController();
	}

	@Test
	public void testAssociaProfessor() {
		Pessoa professor = new Pessoa("024.685.014-52", "Matheus Aldeyncio", "matheus.aldencio@computacao.ufcg.edu.br");
		Proje
		participacaoController.associaProfessor(professor, projeto, true, 120.0, 20);
	}

	@Test
	public void testAssociaGraduando() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssociaProfissional() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveParticipacaoPessoaProjeto() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveParticipacaoPessoa() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveParticipacaoProjeto() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParticipacoesPessoa() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParticipacoesProjeto() {
		fail("Not yet implemented");
	}

}
