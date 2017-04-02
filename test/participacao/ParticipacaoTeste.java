package participacao;
import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.exceptions.FactoryException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoProfessor;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pibiti;
import br.edu.ufcg.projetolp2.util.ValidateUtil;

public class ParticipacaoTeste {

	private Pessoa daniel, juan;
	private Projeto projPed, projCoop, projPibiti;
	private Participacao participacao1, participacao2;

	@Before
	public void setUp() throws FactoryException, ParseException{
		PedFactory factory  = new PedFactory();
		daniel = new Pessoa("Daniel", "daniel@gmail.com", "111.111.111-11");
		juan = new Pessoa("juan", "juazinho@lol.com", "123.123.123-12");		
		
		projCoop = factory.create(112, "coop", "coop", 3, 3, 3, "sSHSAO", "12/12/2011", 1);
		projPibiti = factory.create(111, "pibiti", "pibiti", 1, 2, 3, "12OSHSAO", "14/12/2012", 2);
		
		participacao1 = new ParticipacaoGraduando(projCoop, daniel, 10, 10);
		participacao2 = new ParticipacaoProfessor(projPibiti, juan, 10, 10, false);

	}

	@Test
	public void testParticipacao() {
		try{
			Participacao participacao = new ParticipacaoGraduando(projCoop, daniel, -1, 1);
			fail();
		}catch(ValidacaoException e){
			assertEquals(e.getMessage(), "Quantidade de horas invalida");
		}
		
		try{
			Participacao participacao = new ParticipacaoGraduando(projPibiti, daniel, 10, -1);
			fail();
		}catch(ValidacaoException e){
			assertEquals(e.getMessage(), "Valor da hora invalido");
		}
		
	}

	@Test
	public void testSetQuantHorasSemanais() {
		try{
			participacao1.setQuantHorasSemanais(0);
			fail();
		}catch(ValidacaoException e){
			assertEquals(e.getMessage() , "Quantidade de horas invalida");
		}
		try{
			participacao1.setQuantHorasSemanais(-3);
			fail();
		}catch(ValidacaoException e){
			assertEquals(e.getMessage() , "Quantidade de horas invalida");
		}
	}

	@Test(expected = ValidacaoException.class)
	public void testSetValorHora() {
			participacao2.setQuantHorasSemanais(0);
	}


	@Test
	public void testEqualsObject() {
	
		Participacao participacaoA, participacaoB, participacaoC, participacaoD;
		
		participacaoA = new ParticipacaoGraduando(projCoop, juan, 10, 10);
		participacaoB = new ParticipacaoGraduando(projCoop, juan, 3, 90);
		participacaoC = new ParticipacaoGraduando(projPed, daniel, 10, 10);
		participacaoD = new ParticipacaoProfessor(projCoop, juan, 10, 5, false);
				
		assertTrue(participacaoA.equals(participacaoB));
		assertFalse(participacaoA.equals(participacaoD));
		assertFalse(participacaoA.equals(participacaoC));
		assertFalse(participacaoD.equals(participacaoC));
	
	}

}
