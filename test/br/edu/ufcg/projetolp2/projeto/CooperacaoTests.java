package br.edu.ufcg.projetolp2.projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Cooperacao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;

public class CooperacaoTests {
	Cooperacao projCoop;

	@Before
	public void setUp() throws Exception {
		PedFactory factory  = new PedFactory();
		projCoop = (Cooperacao) factory.create(112, "coop", "coop", 3, 3, 3, "sSHSAO", "12/12/2011", 1);
	}
	
	@Test
	public void testGetInfo() {
		assertEquals("", projCoop.getInfo("coordenador"));
		projCoop.setCoordenador(new Pessoa("num", "uhi@gmial.com", "921.123.312-32"));
		assertEquals("num", projCoop.getInfo("coordenador"));
	}

	@Test
	public void testSetInfo() {
		projCoop.setCoordenador(new Pessoa("num", "uhi@gmial.com", "921.123.312-32"));
		assertEquals("num", projCoop.getInfo("coordenador"));
	}

}
