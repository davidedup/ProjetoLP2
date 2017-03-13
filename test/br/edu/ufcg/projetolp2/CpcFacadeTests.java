package br.edu.ufcg.projetolp2;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.CpcFacade;
import br.edu.ufcg.projetolp2.exceptions.*;


public class CpcFacadeTests {
	CpcFacade facade;
	String MATHEUS_CPF = "024.685.014-52";
	String MATHEUS_NOME = "Matheus Aldeyncio";
	String MATHEUS_EMAIL = "matheus.aldencio@computacao.ufcg.edu.br";
	
	String ABDIAS_CPF = "324.543.674-78";
	String ABDIAS_NOME = "Abdias Melo";
	String ABDIAS_EMAIL = "abdias05@gmail.com";
	
	String ARIANNY_CPF = "234.765.067-64";
	String ARIANNY_NOME = "Arianny Farias";
	String ARIANNY_EMAIL = "arizinha_cc@yahoo.com.br";
	
	String VITOR_CPF = "734.823.922-79";
	String VITOR_NOME = "Vitor Bordas";
	String VITOR_EMAIL = "vit_bor@bol.com.br";
	
	String ERRORCONSULTAPESSOA_PESSOANAOENCONTRADA = "Erro na consulta de pessoa: Pessoa nao encontrada";
	
	String ERRORCADASTROPESSOA_CPFDUPLICADO = "Erro no cadastro de pessoa: Pessoa com mesmo CPF ja cadastrada";
	String ERRORCADASTROPESSOA_NOMENULOVAZIO = "Erro no cadastro de pessoa: Nome nulo ou vazio";
	String ERRORCADASTROPESSOA_EMAILNULOVAZIO = "Erro no cadastro de pessoa: Email nulo ou vazio";
	String ERRORCADASTROPESSOA_EMAILINVALIDO = "Erro no cadastro de pessoa: Email invalido";
	String ERRORCADASTROPESSOA_CPFNULOVAZIO = "Erro no cadastro de pessoa: CPF nulo ou vazio";
	String ERRORCADASTROPESSOA_CPFINVALIDO = "Erro no cadastro de pessoa: CPF invalido";
	
	String ERRORATUALIZACAOPESSOA_PESSOANAOENCONTRADA = "Erro na atualizacao de pessoa: Pessoa nao encontrada";
	String ERRORATUALIZACAOPESSOA_NOMENULOVAZIO = "Erro na atualizacao de pessoa: Nome nulo ou vazio";
	String ERRORATUALIZACAOPESSOA_EMAILNULOVAZIO = "Erro na atualizacao de pessoa: Email nulo ou vazio";
	String ERRORATUALIZACAOPESSOA_EMAILINVALIDO = "Erro na atualizacao de pessoa: Email invalido";
	String ERRORATUALIZACAOPESSOA_CPFALTERAR = "Erro na atualizacao de pessoa: CPF nao pode ser alterado"; 
	
	String ERRORREMOVEPESSOA_PESSOANAOENCONTRADA = "Erro na remocao de pessoa: Pessoa nao encontrada";
	
	@Before
	public void prepara(){
		facade = new CpcFacade();
		facade.iniciaSistema();
	}
	
	public void cadastraPessoas(){
		facade.cadastraPessoa(MATHEUS_CPF, MATHEUS_NOME, MATHEUS_EMAIL);
		facade.cadastraPessoa(ABDIAS_CPF, ABDIAS_NOME, ABDIAS_EMAIL);
	}

	@Test
	public void testCadastraPessoa() {
		assertEquals(ABDIAS_CPF, facade.cadastraPessoa(ABDIAS_CPF, ABDIAS_NOME, ABDIAS_EMAIL));
		assertEquals(ARIANNY_CPF, facade.cadastraPessoa(ARIANNY_CPF, ARIANNY_NOME, ARIANNY_EMAIL));
		assertEquals(VITOR_CPF, facade.cadastraPessoa(VITOR_CPF, VITOR_NOME, VITOR_EMAIL));
		
		try {
			facade.cadastraPessoa(ABDIAS_CPF, ARIANNY_NOME, ARIANNY_EMAIL);
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCADASTROPESSOA_CPFDUPLICADO, e.getMessage());
		}
		
		try {
			facade.cadastraPessoa(null, MATHEUS_NOME, MATHEUS_EMAIL);
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCADASTROPESSOA_CPFNULOVAZIO, e.getMessage());
		}
		
		try {
			facade.cadastraPessoa("   ", MATHEUS_NOME, MATHEUS_EMAIL);
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCADASTROPESSOA_CPFNULOVAZIO, e.getMessage());
		}
		
		try {
			facade.cadastraPessoa("123.4566..-", MATHEUS_NOME, MATHEUS_EMAIL);
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCADASTROPESSOA_CPFINVALIDO, e.getMessage());
		}
		
		try {
			facade.cadastraPessoa(MATHEUS_CPF, null, MATHEUS_EMAIL);
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCADASTROPESSOA_NOMENULOVAZIO, e.getMessage());
		}
		
		try {
			facade.cadastraPessoa(MATHEUS_CPF, "     ", MATHEUS_EMAIL);
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCADASTROPESSOA_NOMENULOVAZIO, e.getMessage());
		}
		
		try {
			facade.cadastraPessoa(MATHEUS_CPF, MATHEUS_NOME, null);
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCADASTROPESSOA_EMAILNULOVAZIO, e.getMessage());
		}
		
		try {
			facade.cadastraPessoa(MATHEUS_CPF, MATHEUS_NOME, "    ");
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCADASTROPESSOA_EMAILNULOVAZIO, e.getMessage());
		}
		
		try {
			facade.cadastraPessoa(MATHEUS_CPF, MATHEUS_NOME, "mestre.dos.magos");
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCADASTROPESSOA_EMAILINVALIDO, e.getMessage());
		}
	}
	
	@Test
	public void testGetInfoPessoa() {
		cadastraPessoas();
		
		assertEquals(MATHEUS_NOME, facade.getInfoPessoa(MATHEUS_CPF, "nome"));
		assertEquals(MATHEUS_EMAIL, facade.getInfoPessoa(MATHEUS_CPF, "email"));
		
		assertEquals(ABDIAS_NOME, facade.getInfoPessoa(ABDIAS_CPF, "nome"));
		assertEquals(ABDIAS_EMAIL, facade.getInfoPessoa(ABDIAS_CPF, "email"));
		
		try {
			facade.getInfoPessoa(VITOR_CPF, "nome");
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCONSULTAPESSOA_PESSOANAOENCONTRADA, e.getMessage());
		}
		
		try {
			facade.getInfoPessoa(VITOR_CPF, "email");
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORCONSULTAPESSOA_PESSOANAOENCONTRADA, e.getMessage());
		}
	}
	
	@Test
	public void testAtualizaPessoa() {
		cadastraPessoas();
		
		assertEquals(MATHEUS_NOME, facade.getInfoPessoa(MATHEUS_CPF, "nome"));
		facade.editaPessoa(MATHEUS_CPF, "nome", "Mestre dos Magos");
		assertEquals("Mestre dos Magos", facade.getInfoPessoa(MATHEUS_CPF, "nome"));
		
		assertEquals(MATHEUS_EMAIL, facade.getInfoPessoa(MATHEUS_CPF, "email"));
		facade.editaPessoa(MATHEUS_CPF, "email", "mestredosmagos@caverna.drag.ao");
		assertEquals("mestredosmagos@caverna.drag.ao", facade.getInfoPessoa(MATHEUS_CPF, "email"));
		
		try {
			facade.editaPessoa(VITOR_CPF, "nome", "Vitor Krum");
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_PESSOANAOENCONTRADA, e.getMessage());
		}
		
		try {
			facade.editaPessoa(MATHEUS_CPF, "nome", null);
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_NOMENULOVAZIO, e.getMessage());
		}
		
		try {
			facade.editaPessoa(MATHEUS_CPF, "nome", "    ");
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_NOMENULOVAZIO, e.getMessage());
		}
		
		try {
			facade.editaPessoa(MATHEUS_CPF, "email", null);
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_EMAILNULOVAZIO, e.getMessage());
		}
		
		try {
			facade.editaPessoa(MATHEUS_CPF, "email", "    ");
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_EMAILNULOVAZIO, e.getMessage());
		}
		
		try {
			facade.editaPessoa(MATHEUS_CPF, "email", "@mestre.magos");
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_EMAILINVALIDO, e.getMessage());
		}		
		try {
			facade.editaPessoa(MATHEUS_CPF, "cpf", "058.014.574-54");
			fail();
		} catch (PessoaException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_CPFALTERAR, e.getMessage());
		}
	}
	
	@Test
	public void testRemovePessoa(){
		cadastraPessoas();
		
		try {
			facade.removePessoa(VITOR_CPF);
			fail();
		} catch (PessoaException e){
			assertEquals(ERRORREMOVEPESSOA_PESSOANAOENCONTRADA, e.getMessage());
		}
		
		facade.removePessoa(MATHEUS_CPF);
		
		try {
			facade.removePessoa(MATHEUS_CPF);
			fail();
		} catch (PessoaException e){
			assertEquals(ERRORREMOVEPESSOA_PESSOANAOENCONTRADA, e.getMessage());
		}
		
		
	}

}
