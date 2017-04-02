package br.edu.ufcg.projetolp2.projeto;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Extensao;

public class ExtensaoTest {

	Extensao ext1;
	
	@Before
	public void setUp() throws ParseException{
		ext1 = new Extensao(0, "aulas", "dar aula", "30/12/16", 10, 5);
	}
	
	@Test
	public void testGetInfo() {
	assertEquals(ext1.getInfo("nome"), "aulas");
	assertEquals(ext1.getInfo("objetivo"), "dar aula");
	assertEquals(ext1.getInfo("impacto"), "5");
	}

	@Test
	public void testSetInfo() {
		try{
			ext1.setInfo("impacto", "10");
		}catch (ValidacaoException e){
			assertEquals(e.getMessage(), "Impacto invalido");
		}
		try{
			ext1.setInfo("campo invalido", "10");
		}catch (ProjetoException e){
			assertEquals(e.getMessage(), "Atributo nulo ou invalido");
		}
	}
	

	@Test
	public void testExtensao() throws ParseException {
		try{
			Extensao ext = new Extensao(0, "ajudar pessoas", "help", "12/10/2016", 12, 7);
		}catch (ValidacaoException e){
			assertEquals(e.getMessage(),"Impacto invalido");
		}
		try{
			Extensao ext = new Extensao(0, "ajudar pessoas", "help", "12/10/2016", 12, 0);
		}catch (ValidacaoException e){
			assertEquals(e.getMessage(),"Impacto invalido");
		}
	}

	@Test
	public void testGetImpacto() {
		assertEquals(5, ext1.getImpacto());
		ext1.setImpacto(4);
		assertEquals(4, ext1.getImpacto());
		ext1.setImpacto(6);
		assertEquals(6, ext1.getImpacto());
	}

	@Test
	public void testSetImpacto() {
		try{
			ext1.setImpacto(7);
		}catch (ValidacaoException e){
			assertEquals(e.getMessage(),"Impacto invalido");
		}
	}

}
