package br.edu.ufcg.projetolp2.projeto;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pivic;

public class PivicTests {
	Pivic projPivic;

	@Before
	public void setUp() throws Exception {
		projPivic = new Pivic(0, "as", "sao", "22/12/2012", 2, 3, 4, 5);

	}

	@Test
	public void testPivic() {
		try {
			Pivic pivic = new Pivic(0, "as", "sao", "22/12/2012", -2, 2, 2, 2);
			fail();
		} catch (ValidacaoException e) {
			assertEquals(e.getMessage(), "Duracao invalida");
		}

		try {
			Pivic pivic = new Pivic(0, "as", "sao", "22/12/2012", 12, -2, 2, 2);
			fail();
		} catch (ValidacaoException e) {
			assertEquals(e.getMessage(), "Numero de producoes tecnicas invalido");
		}

		try {
			Pivic pivic = new Pivic(0, "as", "sao", "22/12/2012", 12, 2, -2, 2);
			fail();
		} catch (ValidacaoException e) {
			assertEquals(e.getMessage(), "Numero de producoes academicas invalido");
		}

		try {
			Pivic pivic = new Pivic(0, "as", "sao", "22/12/2012", 12, 2, 2, -2);
			fail();
		} catch (ValidacaoException e) {
			assertEquals(e.getMessage(), "Numero de patentes invalido");
		}

	}	
	
}
