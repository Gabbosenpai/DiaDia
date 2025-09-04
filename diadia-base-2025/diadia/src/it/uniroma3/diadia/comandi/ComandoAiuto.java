package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */

public class ComandoAiuto implements Comando {

	static final private String[] elencoComandi = {"vai", "guarda", "prendi", "posa", "aiuto", "fine", };
	static final private String NOME = "aiuto";
	
	@Override
	public void esegui(Partita partita) {
			for(int i=0; i< elencoComandi.length; i++) 
				System.out.println(elencoComandi[i]+" ");
			System.out.println("");
	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
