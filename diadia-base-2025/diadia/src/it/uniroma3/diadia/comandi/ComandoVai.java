package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */

public class ComandoVai implements Comando {

	static final private String NOME = "vai";
	
	private String direzione;

	public ComandoVai() {}
	
	@Override
	public void esegui(Partita partita) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null)
				System.out.println("Direzione inesistente");
			else {
				partita.setStanzaCorrente(prossimaStanza);
				int cfu = partita.getGiocatore().getCfu();
				partita.getGiocatore().setCfu(--cfu);
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
		
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
