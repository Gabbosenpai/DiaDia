package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public class Cane extends AbstractPersonaggio {
	
	public static final String MESSAGGIO_MORSO = 
			"*Il cane ti morde la mano...(-1 CFU)*";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		int cfu = partita.getGiocatore().getCfu();
		cfu--;
		partita.getGiocatore().setCfu(cfu);
		return MESSAGGIO_MORSO;
	}
}
