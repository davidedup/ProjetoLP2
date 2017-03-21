package br.edu.ufcg.projetolp2.model.projeto;

import java.text.ParseException;

import br.edu.ufcg.projetolp2.exceptions.FactoryException;
import br.edu.ufcg.projetolp2.exceptions.ProjetoException;
import br.edu.ufcg.projetolp2.exceptions.ValidacaoException;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Cooperacao;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Ped;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pibic;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pibiti;
import br.edu.ufcg.projetolp2.model.projeto.tipos.Pivic;

public class PedFactory {

	/**
	 * cria e retorna um objeto de P&D com o tipo correspondente a sua categoria
	 * @param codigo - codigo do projeto
	 * @param nome - nome do projeto
	 * @param categoria - categoria do projeto
	 * @param prodTecnica - total de producoes tecnicas
	 * @param prodAcademica - total de producoes academicas
	 * @param patentes - total de patentes
	 * @param objetivo - objetivo do projeto
	 * @param dataInicio - data de inicio do projeto
	 * @param duracao - duracao do projeto (em meses)
	 * @return - objeto de P&D com sua categoria correta
	 * @throws FactoryException - formato de data incorreto ou categoria invalida
	 * @throws ParseException - erro na conversao da data
	 */
	public Ped create(int codigo, String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, String dataInicio, int duracao) throws FactoryException, ParseException {
		
		
		if (categoria.equalsIgnoreCase("pibic"))
			return new Pibic(codigo, nome, objetivo, dataInicio, duracao, prodTecnica, prodAcademica, patentes);
		if (categoria.equalsIgnoreCase("pibiti"))
			return new Pibiti(codigo, nome, objetivo, dataInicio, duracao, prodTecnica, prodAcademica, patentes);
		if (categoria.equalsIgnoreCase("pivic"))
			return new Pivic(codigo, nome, objetivo, dataInicio, duracao, prodTecnica, prodAcademica, patentes);
		if (categoria.equalsIgnoreCase("coop"))
			return new Cooperacao(codigo, nome, objetivo, dataInicio, duracao, prodTecnica, prodAcademica, patentes);
		else{
			throw new FactoryException("Categoria invalida");
		}
	}

}
