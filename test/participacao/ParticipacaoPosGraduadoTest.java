package participacao;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.exceptions.CpcException;
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

public class ParticipacaoPosGraduadoTest {
	
	Projeto proj1, proj2, proj3;
	Pessoa daniel,juan,david;
	ParticipacaoPosGraduando participacao;
	
	@Before
	public void setUp() throws ValidacaoException, ParseException, FactoryException {
		PedFactory factory = new PedFactory();
		proj1 = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 12, 8, 8, 8, 2, 8);
		proj2 = new Monitoria(0, "p2", "ensinar", "10/4/2015", 12, "p2", "16.1", 20);
		proj3 = factory.create(111, "pibiti", "pibiti", 12, 12, 3, "12OSHSAO", "14/12/2012", 12);
		
		daniel = new Pessoa("Daniel", "daniel@gmail.com", "111.111.111-11");
		juan = new Pessoa("juan", "juazinho@lol.com", "123.123.123-12");	
		david = new Pessoa("david", "david@cccufcg.com", "444.444.444-11");
		
		participacao = new ParticipacaoPosGraduando(proj3, juan, 10, 10, "mestre");
	}
	
	
	@Test
	public void testCalculaPontos() {
		assertEquals(0, participacao.calculaPontos(),0.05);
	}
	
	@Test
	public void testParticipacaoPosGraduando() {
		try{
			ParticipacaoPosGraduando p = new ParticipacaoPosGraduando(proj2, daniel, 10,10 , "mestre");
		}catch(CpcException e){
			assertEquals(e.getMessage(), "Tipo de projeto invalido para pos graduando");
		}
		try{
			ParticipacaoPosGraduando p = new ParticipacaoPosGraduando(proj1, daniel, 10,10 , "mestre");
		}catch(CpcException e){
			assertEquals(e.getMessage(), "Tipo de projeto invalido para pos graduando");
		}
		try{
			ParticipacaoPosGraduando p = new ParticipacaoPosGraduando(proj1, daniel, 10,10 , "");
		}catch(ValidacaoException e){
			assertEquals(e.getMessage(),"Nivel nulo ou vazio");
		}
		try{
			ParticipacaoPosGraduando p = new ParticipacaoPosGraduando(proj1, daniel, 10, 10 , null);
		}catch(ValidacaoException e){
			assertEquals(e.getMessage(),"Nivel nulo ou vazio");
		}
		
	}
}
