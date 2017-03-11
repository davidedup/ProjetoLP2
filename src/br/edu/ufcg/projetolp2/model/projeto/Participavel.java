package br.edu.ufcg.projetolp2.model.projeto;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;

public interface Participavel {
	void adiciona(Participacao participacao);
	void remove(Participacao participacao);
}
