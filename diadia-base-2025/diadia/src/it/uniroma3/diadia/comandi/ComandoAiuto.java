package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */

public class ComandoAiuto implements Comando {

	static final private String[] elencoComandi = {"vai", "guarda", "prendi", "posa", "aiuto", "fine", };
	static final private String NOME = "aiuto";
	
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
			for(int i=0; i< elencoComandi.length; i++) 
				this.io.mostraMessaggio(elencoComandi[i]+" ");
			this.io.mostraMessaggio("");
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

	@Override
	public void setIO(IO io) {
		this.io = io;
		
	}

}
