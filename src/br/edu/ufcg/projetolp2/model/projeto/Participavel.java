package br.edu.ufcg.projetolp2.model.projeto;

import br.edu.ufcg.projetolp2.model.participacao.Participacao;

public interface Participavel {

	public abstract void adiciona(Participacao participacao);

	public abstract void remove(Participacao participacao);

}
