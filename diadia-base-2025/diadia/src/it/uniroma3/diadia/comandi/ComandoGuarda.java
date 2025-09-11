package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/* Controlla lo stato della partita
 * guardando la stanza corrente, i CFU del giocatore
 * e la sua borsa
 */

public class ComandoGuarda extends AbstractComando {

	static final private String NOME = "guarda";
	
	public ComandoGuarda() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		super.getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		super.getIO().mostraMessaggio("CFU rimasti: " + partita.getGiocatore().getCfu());
		super.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().getContenutoOrdinatoPerPeso().toString());
	}
}
