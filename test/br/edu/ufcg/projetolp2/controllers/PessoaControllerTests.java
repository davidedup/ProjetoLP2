package br.edu.ufcg.projetolp2.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.projetolp2.controllers.PessoaController;
import br.edu.ufcg.projetolp2.exceptions.AtualizacaoException;
import br.edu.ufcg.projetolp2.exceptions.CpcException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;

public class PessoaControllerTests {
	PessoaController pessoas;

	String MATHEUS_CPF = "024.685.014-52";
	String MATHEUS_NOME = "Matheus Aldeyncio";
	String MATHEUS_EMAIL = "matheus.aldencio@computacao.ufcg.edu.br";

	String ABDIAS_CPF = "324.543.674-78";
	String ABDIAS_NOME = "Abdias Melo";
	String ABDIAS_EMAIL = "abdias05@gmail.com";

	String ERRORCONSULTAPESSOA_PESSOANAOENCONTRADA = "Pessoa nao encontrada";

	String ERRORCADASTROPESSOA_CPFDUPLICADO = "Erro no cadastro de pessoa: Pessoa com mesmo CPF ja cadastrada";
	String ERRORCADASTROPESSOA_NOMENULOVAZIO = "Erro no cadastro de pessoa: Nome nulo ou vazio";
	String ERRORCADASTROPESSOA_EMAILNULOVAZIO = "Erro no cadastro de pessoa: Email nulo ou vazio";
	String ERRORCADASTROPESSOA_EMAILINVALIDO = "Erro no cadastro de pessoa: Email invalido";
	String ERRORCADASTROPESSOA_CPFNULOVAZIO = "Erro no cadastro de pessoa: CPF nulo ou vazio";
	String ERRORCADASTROPESSOA_CPFINVALIDO = "Erro no cadastro de pessoa: CPF invalido";

	String ERRORATUALIZACAOPESSOA_NOMENULOVAZIO = "Erro na atualizacao de pessoa: Nome nulo ou vazio";
	String ERRORATUALIZACAOPESSOA_EMAILNULOVAZIO = "Erro na atualizacao de pessoa: Email nulo ou vazio";
	String ERRORATUALIZACAOPESSOA_EMAILINVALIDO = "Erro na atualizacao de pessoa: Email invalido";
	String ERRORATUALIZACAOPESSOA_CPFALTERAR = "Erro na atualizacao de pessoa: CPF nao pode ser alterado";

	@Before
	public void prepara() {
		pessoas = new PessoaController();
	}

	@Test
	public void testCadastro() {
		try {
			pessoas.getPessoa(ABDIAS_CPF);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCONSULTAPESSOA_PESSOANAOENCONTRADA, e.getMessage());
		}
		assertEquals(ABDIAS_CPF, pessoas.cadastraPessoa(ABDIAS_CPF, ABDIAS_NOME, ABDIAS_EMAIL));
		assertEquals(ABDIAS_CPF, pessoas.getPessoa(ABDIAS_CPF).getCpf());

		try {
			pessoas.cadastraPessoa(ABDIAS_CPF, ABDIAS_NOME, ABDIAS_EMAIL);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCADASTROPESSOA_CPFDUPLICADO, e.getMessage());
		}

		try {
			pessoas.cadastraPessoa(null, MATHEUS_NOME, MATHEUS_EMAIL);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCADASTROPESSOA_CPFNULOVAZIO, e.getMessage());
		}

		try {
			pessoas.cadastraPessoa("   ", MATHEUS_NOME, MATHEUS_EMAIL);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCADASTROPESSOA_CPFNULOVAZIO, e.getMessage());
		}

		try {
			pessoas.cadastraPessoa("123.4566..-", MATHEUS_NOME, MATHEUS_EMAIL);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCADASTROPESSOA_CPFINVALIDO, e.getMessage());
		}

		try {
			pessoas.cadastraPessoa(MATHEUS_CPF, null, MATHEUS_EMAIL);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCADASTROPESSOA_NOMENULOVAZIO, e.getMessage());
		}

		try {
			pessoas.cadastraPessoa(MATHEUS_CPF, "     ", MATHEUS_EMAIL);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCADASTROPESSOA_NOMENULOVAZIO, e.getMessage());
		}

		try {
			pessoas.cadastraPessoa(MATHEUS_CPF, MATHEUS_NOME, null);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCADASTROPESSOA_EMAILNULOVAZIO, e.getMessage());
		}

		try {
			pessoas.cadastraPessoa(MATHEUS_CPF, MATHEUS_NOME, "    ");
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCADASTROPESSOA_EMAILNULOVAZIO, e.getMessage());
		}

		try {
			pessoas.cadastraPessoa(MATHEUS_CPF, MATHEUS_NOME, "mestre.dos.magos");
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCADASTROPESSOA_EMAILINVALIDO, e.getMessage());
		}
	}

	@Test
	public void testEdita() {
		pessoas.cadastraPessoa(MATHEUS_CPF, MATHEUS_NOME, MATHEUS_EMAIL);

		assertEquals(MATHEUS_EMAIL, pessoas.getInfoPessoa(MATHEUS_CPF, "email"));
		pessoas.editaPessoa(MATHEUS_CPF, "email", "mestre@magos.com");
		assertEquals("mestre@magos.com", pessoas.getInfoPessoa(MATHEUS_CPF, "email"));

		assertEquals(MATHEUS_NOME, pessoas.getInfoPessoa(MATHEUS_CPF, "nome"));
		pessoas.editaPessoa(MATHEUS_CPF, "nome", "Mestre dos Magos");
		assertEquals("Mestre dos Magos", pessoas.getInfoPessoa(MATHEUS_CPF, "nome"));
		try {
			pessoas.editaPessoa(MATHEUS_CPF, "email", null);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_EMAILNULOVAZIO, e.getMessage());
		}

		try {
			pessoas.editaPessoa(MATHEUS_CPF, "email", "   ");
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_EMAILNULOVAZIO, e.getMessage());
		}

		try {
			pessoas.editaPessoa(MATHEUS_CPF, "email", "novoemail.com");
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_EMAILINVALIDO, e.getMessage());
		}

		try {
			pessoas.editaPessoa(MATHEUS_CPF, "nome", null);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_NOMENULOVAZIO, e.getMessage());
		}

		try {
			pessoas.editaPessoa(MATHEUS_CPF, "cpf", "   ");
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_CPFALTERAR, e.getMessage());
		}
		try {
			pessoas.editaPessoa(MATHEUS_CPF, "cpf", ABDIAS_CPF);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORATUALIZACAOPESSOA_CPFALTERAR, e.getMessage());
		}
	}

	@Test
	public void testRemove() {
		pessoas.cadastraPessoa(MATHEUS_CPF, MATHEUS_NOME, MATHEUS_EMAIL);

		pessoas.getPessoa(MATHEUS_CPF);
		pessoas.removePessoa(MATHEUS_CPF);

		try {
			pessoas.getPessoa(MATHEUS_CPF);
			fail();
		} catch (CpcException e) {
			assertEquals(ERRORCONSULTAPESSOA_PESSOANAOENCONTRADA, e.getMessage());
		}

	}
}
