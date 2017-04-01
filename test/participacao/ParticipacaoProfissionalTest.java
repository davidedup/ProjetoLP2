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
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfissional;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;

public class ParticipacaoProfissionalTest {

	Projeto proj1, proj2, proj3;
	Pessoa daniel,juan,david;
	ParticipacaoProfissional participacaoProfissional1, participacaoProfissional2, participacaoProfissional3;
	
	@Before
	public void setUp() throws ValidacaoException, ParseException, FactoryException {
		PedFactory factory = new PedFactory();
		proj1 = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 12, 8, 8, 8, 2, 8);
		proj2 = new Monitoria(0, "p2", "ensinar", "10/4/2015", 12, "p2", "16.1", 20);
		proj3 = factory.create(111, "pibiti", "pibiti", 12, 12, 3, "12OSHSAO", "14/12/2012", 12);
		
		daniel = new Pessoa("Daniel", "daniel@gmail.com", "111.111.111-11");
		juan = new Pessoa("juan", "juazinho@lol.com", "123.123.123-12");	
		david = new Pessoa("david", "david@cccufcg.com", "444.444.444-11");
		
		participacaoProfissional1 = new ParticipacaoProfissional(proj1, daniel, 10, 10, "desenvolvedor");
		participacaoProfissional2 = new ParticipacaoProfissional(proj2, david, 10, 10, "gerente");
		participacaoProfissional3 = new ParticipacaoProfissional(proj3, juan, 10,10, "pesquisador");
		
	}
	
	
	@Test
	public void testCalculaPontos() {
		//Só pontua se for do tipo PeD:
		assertEquals(0,participacaoProfissional1.calculaPontos(),0.05);
		assertEquals(0,participacaoProfissional2.calculaPontos(),0.05);
		
		assertEquals(6,participacaoProfissional3.calculaPontos(),0.05);
		participacaoProfissional3.setCargo("gerente");
		assertEquals(9,participacaoProfissional3.calculaPontos(),0.05);
		participacaoProfissional3.setCargo("desenvolvedor");
		assertEquals(5,participacaoProfissional3.calculaPontos(),0.05);
		
		proj3.setDuracao(24);
		assertEquals(10,participacaoProfissional3.calculaPontos(),0.05);
		proj3.setDuracao(20);
		assertEquals(5,participacaoProfissional3.calculaPontos(),0.05);
		proj3.setDuracao(36);
		participacaoProfissional3.setCargo("pesquisador");
		assertEquals(18,participacaoProfissional3.calculaPontos(),0.05);
		
	}
	
	public void testParticipacaoProfissional(){
		try{
			ParticipacaoProfissional  p = new ParticipacaoProfissional(proj1, daniel, 10, 10, null);
		}catch (ValidacaoException e) {
			assertEquals(e.getMessage(), "Cargo nulo ou vazio");
		}
		try{
			ParticipacaoProfissional  p = new ParticipacaoProfissional(proj1, daniel, 10, 10, "");
		}catch (ValidacaoException e) {
			assertEquals(e.getMessage(), "Cargo nulo ou vazio");
		}
	}

}
