package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/* Controlla lo stato della partita
 * guardando la stanza corrente, i CFU del giocatore
 * e la sua borsa
 */

public class ComandoGuarda implements Comando {

	static final private String NOME = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		System.out.println("CFU rimasti: " + partita.getGiocatore().getCfu());
		System.out.println(partita.getGiocatore().getBorsa().toString());
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
