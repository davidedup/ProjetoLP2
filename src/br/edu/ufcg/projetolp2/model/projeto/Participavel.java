package br.edu.ufcg.projetolp2.model.projeto;

import br.edu.ufcg.projetolp2.exceptions.AssociacaoException;
import br.edu.ufcg.projetolp2.model.participacao.Participacao;

public interface Participavel {
	/**
	 * performa a logica associada do objeto ao ser associado em uma Participacao
	 * @param participacao - objeto Participacao que pretende associar o Participavel
	 * @throws AssociacaoException - erro causado por associacao de Participacao indevida
	 */
	void adiciona(Participacao participacao) throws AssociacaoException;
	
	/**
	 * performa a logica associada do objeto ao ser removido em uma Participacao
	 * @param participacao - objeto Participacao que pretende desassociar do Participavel
	 */
	void remove(Participacao participacao);
}
