package participacao;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.exceptions.FactoryException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.participacao.tipos.ParticipacaoGraduando;
import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;
import br.edu.ufcg.projetolp2.model.projeto.PedFactory;
import br.edu.ufcg.projetolp2.model.projeto.Projeto;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Monitoria;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pet;

public class ParticipacaoGraduandoTest {

	Projeto proj1, proj2, proj3;
	Pessoa daniel;
	ParticipacaoGraduando participacaoGraduando1, participacaoGraduando2, participacaoGraduando3;

	@Before
	public void setUp() throws ValidacaoException, ParseException, FactoryException {
		PedFactory factory = new PedFactory();
		proj1 = new Pet(0, "OPI", "Levar os jovens a olimpiada", "10/02/2019", 12, 6, 8, 8, 2, 8);
		proj2 = new Monitoria(0, "p2", "ensinar", "10/4/2015", 12, "p2", "16.1", 20);
		proj3 = factory.create(111, "pibiti", "pibiti", 12, 12, 3, "12OSHSAO", "14/12/2012", 12);
		daniel = new Pessoa("Daniel", "daniel@gmail.com", "111.111.111-11");
		participacaoGraduando1 = new ParticipacaoGraduando(proj1, daniel, 10, 10);
		participacaoGraduando2 = new ParticipacaoGraduando(proj2, daniel, 30, 10);
		participacaoGraduando3 = new ParticipacaoGraduando(proj3, daniel, 10, 20);
	}

	@Test
	public void testCalculaPontos() {
		assertEquals(4, participacaoGraduando1.calculaPontos(), 0.05);
		assertEquals(3, participacaoGraduando2.calculaPontos(), 0.05);
		assertEquals(4, participacaoGraduando3.calculaPontos(), 0.05);

		proj1.setDuracao(7);
		assertEquals(2, participacaoGraduando1.calculaPontos(), 0.05);
		proj1.setDuracao(20);
		assertEquals(6, participacaoGraduando1.calculaPontos(), 0.05);
		proj2.setDuracao(8);
		assertEquals(1.5, participacaoGraduando2.calculaPontos(), 0.05);
		proj2.setDuracao(18);
		assertEquals(4.5, participacaoGraduando2.calculaPontos(), 0.05);
		proj3.setDuracao(20);
		assertEquals(6, participacaoGraduando3.calculaPontos(), 0.05);
		
		//dura��o menor que 6 meses
		proj1.setDuracao(2);
		assertEquals(0, participacaoGraduando1.calculaPontos(), 0.05);
		proj2.setDuracao(3);
		assertEquals(0, participacaoGraduando2.calculaPontos(), 0.05);
	}

}
