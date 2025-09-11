package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */

public class ComandoVai extends AbstractComando {

	static final private String NOME = "vai";

	public ComandoVai() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		String direzione = super.getParametro();
		if(direzione==null)
			super.getIO().mostraMessaggio("Dove vuoi andare ?");
		else {
			Stanza corrente = partita.getStanzaCorrente();
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null)
				super.getIO().mostraMessaggio("Direzione inesistente");
			else {
				partita.setStanzaCorrente(prossimaStanza);
				int cfu = partita.getGiocatore().getCfu();
				if(!corrente.equals(prossimaStanza))
					partita.getGiocatore().setCfu(--cfu);
			}
		}
	}
}
