package participacao;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.exceptions.FactoryException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoPosGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;

public class ParticipacaoProfessorTest {

	Projeto proj1, proj2, proj3;
	Pessoa daniel,juan,david;
	ParticipacaoProfessor participacaoProf1, participacaoProf2, participacaoProf3;;
	ParticipacaoGraduando participacaoGraduando1, participacaoGraduando2, participacaoGraduando3;
	ParticipacaoPosGraduando participacaoPos1, participacaoPos2;
	
	@Before
	public void setUp() throws ValidacaoException, ParseException, FactoryException {
		PedFactory factory = new PedFactory();
		proj1 = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 12, 6, 8, 8, 2, 8);
		proj2 = new Monitoria(0, "p2", "ensinar", "10/4/2015", 12, "p2", "16.1", 20);
		proj3 = factory.create(111, "pibiti", "pibiti", 12, 12, 3, "12OSHSAO", "14/12/2012", 12);
		
		daniel = new Pessoa("Daniel", "daniel@gmail.com", "111.111.111-11");
		juan = new Pessoa("juan", "juazinho@lol.com", "123.123.123-12");	
		david = new Pessoa("david", "david@cccufcg.com", "444.444.444-11");
		
		participacaoProf1 = new ParticipacaoProfessor(proj1, daniel, 10, 10, true);
		participacaoProf2 = new ParticipacaoProfessor(proj2, daniel, 30, 10, false);
		participacaoProf3 = new ParticipacaoProfessor(proj3, juan, 10, 20, true);
		
		participacaoGraduando1 = new ParticipacaoGraduando(proj1, daniel, 10, 10);
		participacaoGraduando2 = new ParticipacaoGraduando(proj2, juan, 30, 10);
		participacaoGraduando3 = new ParticipacaoGraduando(proj3, david, 10, 20);
		participacaoPos1 = new ParticipacaoPosGraduando(proj3, david, 10, 10, "mestre");
		participacaoPos2 = new ParticipacaoPosGraduando(proj3, daniel, 1, 10, "doutor");
	}
	
	@Test
	public void testCalculaPontos() {
		//Monitoria:
		assertEquals(4, participacaoProf2.calculaPontos(), 0.05);
		proj2.setDuracao(6);
		assertEquals(0, participacaoProf2.calculaPontos(), 0.05);
		proj2.setDuracao(24);
		assertEquals(8, participacaoProf2.calculaPontos(), 0.05);
		proj2.setDuracao(15);
		assertEquals(4, participacaoProf2.calculaPontos(), 0.05);
	
		proj1.adicionaParticipacao(participacaoGraduando1);
		assertEquals(5, participacaoProf1.calculaPontos(), 0.05);
		proj1.adicionaParticipacao(participacaoGraduando2);
		assertEquals(6, participacaoProf1.calculaPontos(), 0.05);
		proj1.adicionaParticipacao(participacaoPos1);
		assertEquals(7, participacaoProf1.calculaPontos(), 0.05);
		proj1.setDuracao(24);
		assertEquals(11, participacaoProf1.calculaPontos(), 0.05);
		
		
		assertEquals(4, participacaoProf3.calculaPontos(), 0.05);
		proj3.adicionaParticipacao(participacaoGraduando1);
		assertEquals(5, participacaoProf3.calculaPontos(), 0.05);
		proj3.setDuracao(24);
		assertEquals(9, participacaoProf3.calculaPontos(), 0.05);
	}
	
	@Test
	public void testGetCoordenador() {
		assertTrue(participacaoProf1.getCoordenador());
		assertFalse(participacaoProf2.getCoordenador());
		assertTrue(participacaoProf3.getCoordenador());
	}

}
