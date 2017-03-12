package br.edu.ufcg.projetolp2.model.pessoa;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.model.pessoa.Pessoa;


public class PessoaTests {
	String MATHEUS_CPF = "024.685.014-52";
	String MATHEUS_NOME = "Matheus Aldeyncio";
	String MATHEUS_EMAIL = "matheus.aldencio@computacao.ufcg.edu.br";
	Pessoa Matheus;
	
	String ABDIAS_CPF = "324.543.674-78";
	String ABDIAS_NOME = "Abdias Melo";
	String ABDIAS_EMAIL = "abdias05@gmail.com";
	Pessoa Abdias;
	
	@Before
	public void prepara(){
		Matheus = new Pessoa(MATHEUS_NOME, MATHEUS_EMAIL, MATHEUS_CPF);
		Abdias = new Pessoa(ABDIAS_NOME, ABDIAS_EMAIL, ABDIAS_CPF);
	}
	
	@Test
	public void testaComparacao() {
		assertEquals(MATHEUS_CPF, Matheus.getCpf());
		assertEquals(MATHEUS_NOME, Matheus.getNome());
		assertEquals(MATHEUS_EMAIL, Matheus.getEmail());

		Pessoa Matheus2 = new Pessoa("Outro Nome", "outro@email.com", MATHEUS_CPF);
		
		assertEquals(Matheus.hashCode(), Matheus2.hashCode());
		assertEquals(true, Matheus.equals(Matheus2));
		
		assertEquals(false, Matheus.hashCode() == Abdias.hashCode());
		assertEquals(false, Matheus.equals(Abdias));
		
		int matheusHash = Matheus.hashCode();
		
		Matheus.setEmail("mestre@magos.com");
		Matheus.setNome("Mestre dos Magos");
		
		assertEquals(matheusHash, Matheus.hashCode());
	}
}
