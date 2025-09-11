package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/*
 * Comando non riconosciuto
 */

public class ComandoNonValido extends AbstractComando {

	static final private String NOME = "non valido";
	
	public ComandoNonValido() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		super.getIO().mostraMessaggio("Comando non valido!");
	}

}
