package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {

	static final private String NOME = "prendi";

	public ComandoPrendi() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		String nomeAttrezzo = super.getParametro();
		if(nomeAttrezzo == null) {
			super.getIO().mostraMessaggio("Cosa vuoi prendere?");
			return;
		}
		if(!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			super.getIO().mostraMessaggio("L'attrezzo " + nomeAttrezzo + " non c'è nella stanza!");
			return;
		}
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().addAttrezzo(a)) {
			partita.getStanzaCorrente().removeAttrezzo(a);
			super.getIO().mostraMessaggio("Attrezzo " + nomeAttrezzo + " preso!");
		}
		else {
			super.getIO().mostraMessaggio("Non c'è spazio nella borsa!");
		}
	}
}
