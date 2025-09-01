package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;

	public ComandoVai() {}

	/**
	 * esecuzione del comando
	 */	
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

}
