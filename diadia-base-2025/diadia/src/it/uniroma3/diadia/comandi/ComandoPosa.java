package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {

	static final private String NOME = "posa";

	public ComandoPosa() {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		String nomeAttrezzo = super.getParametro();
		if(nomeAttrezzo == null) {
			super.getIO().mostraMessaggio("Cosa vuoi posare?");
			return;
		}
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			super.getIO().mostraMessaggio("L'attrezzo " + nomeAttrezzo + " non c'è nella borsa!");
			return;
		}
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(partita.getStanzaCorrente().addAttrezzo(a)) {
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			super.getIO().mostraMessaggio("Attrezzo " + nomeAttrezzo + " posato!");
		}
		else {
			super.getIO().mostraMessaggio("Non c'è spazio nella stanza!");
		}
	}
}
