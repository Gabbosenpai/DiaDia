package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Comando "Fine".
 */

public class ComandoFine implements Comando {

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		System.out.println("Grazie di aver giocato!");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
