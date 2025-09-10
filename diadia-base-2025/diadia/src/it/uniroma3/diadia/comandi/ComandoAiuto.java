package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */

public class ComandoAiuto extends AbstractComando {

	static final private String[] elencoComandi = {"vai", "guarda", 
			"interagisci", "saluta", "prendi", "posa", "aiuto", "fine", };
	
	static final private String NOME = "aiuto";
	
	public ComandoAiuto() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
			for(int i=0; i< elencoComandi.length; i++) 
				super.getIO().mostraMessaggio(elencoComandi[i]+" ");
			super.getIO().mostraMessaggio("");
	}
}
